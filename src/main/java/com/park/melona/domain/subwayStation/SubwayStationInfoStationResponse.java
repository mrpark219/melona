package com.park.melona.domain.subwayStation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SubwayStationInfoStationResponse {

	@JsonProperty("STATION_CD")
	private String stationCode;

	@JsonProperty("STATION_NM")
	private String stationName;

	@JsonProperty("LINE_NUM")
	private String lineNumber;

	@JsonProperty("FR_CODE")
	private String frCode;

	@JsonProperty("STATION_NM_ENG")
	private String stationNameEnglish;

	@JsonProperty("STATION_NM_CHN")
	private String stationNameChinese;

	@JsonProperty("STATION_NM_JPN")
	private String stationNameJapanese;

}
