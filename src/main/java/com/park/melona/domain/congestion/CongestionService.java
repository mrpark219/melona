package com.park.melona.domain.congestion;

import com.park.melona.global.util.ObjectUtil;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CongestionService {

	private final CongestionApiService congestionApiService;

	public CongestionService(CongestionApiService congestionApiService) {
		this.congestionApiService = congestionApiService;
	}

	public CongestionResponse selectCongestion(String subwayId, Long trainNo) {

		CongestionApiResponse congestionApiResponse = congestionApiService.getArrivalInformationApiCache(subwayId, trainNo);

		if(ObjectUtil.isEmpty(congestionApiResponse)) {
			return null;
		}

		List<Long> congestionCarList = Arrays.stream(congestionApiResponse.getData().getCongestionResult().getCongestionCar().split("\\|"))
				.map(Long::parseLong)
				.toList();

		return CongestionResponse.builder()
				.trainNo(Long.valueOf(congestionApiResponse.getData().getTrainY()))
				.congestionTrain(Long.valueOf(congestionApiResponse.getData().getCongestionResult().getCongestionTrain()))
				.congestionCarList(congestionCarList)
				.build();
	}
}
