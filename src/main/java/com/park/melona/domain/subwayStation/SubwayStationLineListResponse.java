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

	private String subwayLineId;

	private String subwayLineName;

	public SubwayStationLineListResponse(String subwayLineId, String subwayLineName) {
		this.subwayLineId = subwayLineId;
		this.subwayLineName = subwayLineName;
	}
}
