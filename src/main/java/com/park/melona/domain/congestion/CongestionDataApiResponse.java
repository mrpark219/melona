package com.park.melona.domain.congestion;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CongestionDataApiResponse {

	@JsonProperty("subwayLine")
	private String subwayLine;

	@JsonProperty("trainY")
	private String trainY;

	@JsonProperty("congestionResult")
	private CongestionResultApiResponse congestionResult;

}
