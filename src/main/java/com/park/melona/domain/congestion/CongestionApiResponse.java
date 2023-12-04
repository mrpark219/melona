package com.park.melona.domain.congestion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CongestionApiResponse {

	@JsonProperty("success")
	private Boolean success;

	@JsonProperty("code")
	private Integer code;

	@JsonProperty("msg")
	private String msg;

	@JsonProperty("data")
	private CongestionDataApiResponse data;

}
