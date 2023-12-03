package com.park.melona.domain.arrivalInfomation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class ArrivalInformationApiResponse {

	/**
	 * 공통: 요청 결과
	 */
	@JsonProperty("errorMessage")
	private ArrivalInformationResultApiResponse result;

	/**
	 * 열차 도착 정보 리스트
	 */
	@JsonProperty("realtimeArrivalList")
	private List<ArrivalInformationListApiResponse> realtimeArrivalList;
}
