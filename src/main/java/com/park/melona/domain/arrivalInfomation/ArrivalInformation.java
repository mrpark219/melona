package com.park.melona.domain.arrivalInfomation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ArrivalInformation {

	/**
	 * 종착역명
	 */
	private String terminusStationName;

	/**
	 * 열차번호
	 */
	private String trainNo;

	/**
	 * 현재 역명
	 */
	private String currentStationName;

	/**
	 * 도착 예정 시간(초)
	 */
	private Long eta;

	/**
	 * 도착 예정 시간 문자
	 */
	private String etaString;

	public ArrivalInformation(String terminusStationName, String trainNo, String currentStationName, Long eta, String etaString) {
		this.terminusStationName = terminusStationName;
		this.trainNo = trainNo;
		this.currentStationName = currentStationName;
		this.eta = eta;
		this.etaString = etaString;
	}
}
