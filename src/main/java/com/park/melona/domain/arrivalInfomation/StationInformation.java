package com.park.melona.domain.arrivalInfomation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StationInformation {

	/**
	 * 역 ID
	 */
	private String stationId;

	/**
	 * 역명
	 */
	private String stationName;


	public StationInformation(String stationId, String stationName) {
		this.stationId = stationId;
		this.stationName = stationName;
	}
}
