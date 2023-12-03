package com.park.melona.domain.arrivalInfomation;

import jooq.gernated.tables.pojos.SubwayStation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Builder
public class ArrivalInformationResponse {

	/**
	 * 현재역 정보
	 */
	private SubwayStation currentStationInformation;

	/**
	 * 이전역 정보 목록
	 */
	private List<SubwayStation> previousStationInformationList;

	/**
	 * 다음역 정보 목록
	 */
	private List<SubwayStation> nextStationInformationList;

	/**
	 * 상행선 도착 정보
	 */
	private List<ArrivalInformation> upLineArrivalInformationList;

	/**
	 * 하행선 도착 정보
	 */
	private List<ArrivalInformation> downLineArrivalInformationList;

	public ArrivalInformationResponse(SubwayStation currentStationInformation, List<SubwayStation> previousStationInformationList, List<SubwayStation> nextStationInformationList, List<ArrivalInformation> upLineArrivalInformationList, List<ArrivalInformation> downLineArrivalInformationList) {
		this.currentStationInformation = currentStationInformation;
		this.previousStationInformationList = previousStationInformationList;
		this.nextStationInformationList = nextStationInformationList;
		this.upLineArrivalInformationList = upLineArrivalInformationList;
		this.downLineArrivalInformationList = downLineArrivalInformationList;
	}
}
