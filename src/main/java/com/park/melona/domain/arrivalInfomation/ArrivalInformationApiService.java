package com.park.melona.domain.arrivalInfomation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class ArrivalInformationApiService {

	private final RestTemplate restTemplate;

	private final String REAL_TIME_BASE_URL;

	private final String REAL_TIME_URL;

	private final String OPEN_API_REAL_TIME_KEY;

	private final Long REAL_TIME_ARRIVAL_LIST_TOTAL;

	public ArrivalInformationApiService(RestTemplate restTemplate, @Value("${open-api.real-time-base-url}") String realTimeBaseUrl, @Value("${open-api.real-time-url}") String realTimeUrl, @Value("${open-api.real-time-api-key}") String openApiRealTimeKey, @Value("${open-api.real-time-arrival-list-total}") Long realTimeArrivalListTotal) {
		this.restTemplate = restTemplate;
		REAL_TIME_BASE_URL = realTimeBaseUrl;
		REAL_TIME_URL = realTimeUrl;
		OPEN_API_REAL_TIME_KEY = openApiRealTimeKey;
		REAL_TIME_ARRIVAL_LIST_TOTAL = realTimeArrivalListTotal;
	}

	/**
	 * 지하철 실시간 도착정보 API 요청 Cache
	 * @param stationName import lombok.extern.slf4j.Slf4j;
	 * @return 지하철 실시간 도착정보 API 요청 결과
	 */
	@Cacheable(cacheNames = "arrivalInformationApi", key = "#stationName")
	public ArrivalInformationApiResponse getArrivalInformationApiCache(String stationName) {
		return this.getArrivalInformationApi(stationName, REAL_TIME_ARRIVAL_LIST_TOTAL);
	}

	/**
	 * 지하철 실시간 도착정보 API 요청
	 *
	 * @param stationName 지하철역명
	 * @param totalSize   조회할 전체 크기
	 * @return 지하철 실시간 도착정보 API 요청 결과
	 */
	public ArrivalInformationApiResponse getArrivalInformationApi(String stationName, Long totalSize) {
		URI uri = UriComponentsBuilder
				.fromUri(URI.create(REAL_TIME_BASE_URL + REAL_TIME_URL))
				.pathSegment(OPEN_API_REAL_TIME_KEY, "json", "realtimeStationArrival", "0", String.valueOf(totalSize), stationName)
				.encode()
				.build()
				.toUri();

		try {
			ArrivalInformationApiResponse arrivalInformationApiResponse = restTemplate.getForObject(uri, ArrivalInformationApiResponse.class);

			assert arrivalInformationApiResponse != null;
			if(!arrivalInformationApiResponse.getResult().getCode().equals("INFO-000")) {
				log.info("지하철 실시간 도착정보 조회에 실패하였습니다: " + arrivalInformationApiResponse.getResult().getCode() + "-" + arrivalInformationApiResponse.getResult().getMessage());
				return null;
			}

			if(arrivalInformationApiResponse.getResult().getTotal() < totalSize) {
				return getArrivalInformationApi(stationName, arrivalInformationApiResponse.getResult().getTotal());
			}

			return arrivalInformationApiResponse;
		}
		catch(Exception e) {
			log.info("지하철 실시간 도착정보 조회에 실패하였습니다");
			return null;
		}
	}

}
