package com.park.melona.domain.subwayStation;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SubwayStationLineListResponse {

	/**
	 * 호선 ID
	 */
	private String subwayLineId;

	/**
	 * 호선 이름
	 */
	private String subwayLineName;

	/**
	 * 시발역 이름
	 */
	private String startingStationName;

	/**
	 * 종착역 이름
	 */
	private String terminusStationName;

	public SubwayStationLineListResponse(String subwayLineId, String subwayLineName, String startingStationName, String terminusStationName) {
		this.subwayLineId = subwayLineId;
		this.subwayLineName = subwayLineName;
		this.startingStationName = startingStationName;
		this.terminusStationName = terminusStationName;
	}
}
