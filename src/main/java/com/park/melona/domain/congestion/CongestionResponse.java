package com.park.melona.domain.congestion;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CongestionResponse {

	/**
	 * 열차번호
	 */
	Long trainNo;

	/**
	 * 칸별 혼잡도 평균
	 */
	Long congestionTrain;

	/**
	 * 칸별 혼잡도
	 */
	List<Long> congestionCarList;

	public CongestionResponse(Long trainNo, Long congestionTrain, List<Long> congestionCarList) {
		this.trainNo = trainNo;
		this.congestionTrain = congestionTrain;
		this.congestionCarList = congestionCarList;
	}
}
