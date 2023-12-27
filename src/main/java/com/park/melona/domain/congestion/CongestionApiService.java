package com.park.melona.domain.congestion;

import com.park.melona.domain.subwayStation.SubwayStationLineType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class CongestionApiService {

	private final RestTemplate restTemplate;

	private final String SK_API_BASE_URL;

	private final String CONGESTION_API_URL;

	private final String SK_API_KEY;

	public CongestionApiService(RestTemplate restTemplate, @Value("${sk-api.base-url}") String skApiBaseUrl, @Value("${sk-api.congestion-url}") String congestionApiUrl, @Value("${sk-api.api-key}") String skApiKey) {
		this.restTemplate = restTemplate;
		SK_API_BASE_URL = skApiBaseUrl;
		CONGESTION_API_URL = congestionApiUrl;
		SK_API_KEY = skApiKey;
	}

	@Cacheable(cacheNames = "arrivalInformationApi", key = "#subwayId + #trainNo")
	public CongestionApiResponse getArrivalInformationApiCache(String subwayId, Long trainNo) {

		// 2호선, 3호선만 제공
		String subwayLine;
		if(subwayId.equals(SubwayStationLineType.LINE_1002.getKey())) {
			subwayLine = "2";
		}
		else if(subwayId.equals(SubwayStationLineType.LINE_1003.getKey())) {
			subwayLine = "3";
		}
		else {
			return null;
		}

		URI uri = UriComponentsBuilder
				.fromUri(URI.create(SK_API_BASE_URL + CONGESTION_API_URL))
				.pathSegment(subwayLine, String.valueOf(trainNo))
				.build()
				.toUri();

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("appkey", SK_API_KEY);
			HttpEntity<String> request = new HttpEntity<>(headers);

			CongestionApiResponse congestionApiResponse = restTemplate.exchange(uri, HttpMethod.GET, request, CongestionApiResponse.class).getBody();

			assert congestionApiResponse != null;
			if(!congestionApiResponse.getSuccess() || !congestionApiResponse.getCode().equals(0)) {
				log.info("실시간 혼잡도 정보 조회에 실패하였습니다: " + congestionApiResponse.getCode() + "-" + congestionApiResponse.getMsg());
				return null;
			}

			return congestionApiResponse;
		}
		catch(Exception e) {
			log.info("실시간 혼잡도 정보 조회에 실패하였습니다");
			return null;
		}
	}
}
