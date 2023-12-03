package com.park.melona.domain.arrivalInfomation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ArrivalInformationResultApiResponse {

	@JsonProperty("status")
	private int status;

	@JsonProperty("code")
	private String code;

	@JsonProperty("message")
	private String message;

	@JsonProperty("link")
	private String link;

	@JsonProperty("developerMessage")
	private String developerMessage;

	@JsonProperty("total")
	private Long total;


}
