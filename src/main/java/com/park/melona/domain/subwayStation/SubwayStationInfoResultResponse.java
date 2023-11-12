package com.park.melona.domain.subwayStation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SubwayStationInfoResultResponse {

	@JsonProperty("CODE")
	private String code;

	@JsonProperty("MESSAGE")
	private String message;

}
