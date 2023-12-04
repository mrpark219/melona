package com.park.melona.domain.congestion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CongestionResultApiResponse {

	@JsonProperty("congestionTrain")
	private String congestionTrain;

	@JsonProperty("congestionCar")
	private String congestionCar;

	@JsonProperty("congestionType")
	private Integer congestionType;

}
