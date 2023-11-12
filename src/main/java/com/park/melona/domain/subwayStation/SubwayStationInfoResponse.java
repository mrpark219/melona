package com.park.melona.domain.subwayStation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class SubwayStationInfoResponse {

	@JsonProperty("list_total_count")
	private Long listTotalCount;

	@JsonProperty("RESULT")
	private SubwayStationInfoResultResponse result;

	@JsonProperty("row")
	private List<SubwayStationInfoStationResponse> stations;

}
