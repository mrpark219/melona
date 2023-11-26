package com.park.melona.domain.subwayStation;

import com.park.melona.global.config.EnumModel;
import lombok.Getter;

public enum SubwayStationLineType implements EnumModel {

	LINE_1001("1호선", "소요산", "인천/신창"),
	LINE_1002("2호선", "신도림", "강남"),
	LINE_1003("3호선", "대화", "오금"),
	LINE_1004("4호선", "당고개", "오이도"),
	LINE_1005("5호선", "방화", "상일동"),
	LINE_1006("6호선", "응암", "신내"),
	LINE_1007("7호선", "장암", "부평구청"),
	LINE_1008("8호선", "암사", "모란"),
	LINE_1009("9호선", "개화", "중앙보훈병원");

	/*LINE_1061("중앙선", startingStationName, terminusStationName),
	LINE_1063("경의중앙선", startingStationName, terminusStationName),
	LINE_1065("공항철도", startingStationName, terminusStationName),
	LINE_1067("경춘선", startingStationName, terminusStationName),
	LINE_1075("수의분당선", startingStationName, terminusStationName),
	LINE_1077("신분당선", startingStationName, terminusStationName),
	LINE_1092("우이신설선", startingStationName, terminusStationName),
	LINE_1093("서해선", startingStationName, terminusStationName),
	LINE_1081("경강선", startingStationName, terminusStationName);*/

	private final String value;

	@Getter
	private final String startingStationName;

	@Getter
	private final String terminusStationName;

	SubwayStationLineType(String value, String startingStationName, String terminusStationName) {
		this.value = value;
		this.startingStationName = startingStationName;
		this.terminusStationName = terminusStationName;
	}

	@Override
	public String getKey() {
		return name();
	}

	@Override
	public String getValue() {
		return value;
	}

	public static String getStartingStationNameByKey(String key) {
		for(SubwayStationLineType e : values()) {
			if(e.getKey().equals(key)) {
				return e.getStartingStationName();
			}
		}
		return null;
	}

	public static String getTerminusStationNameByKey(String key) {
		for(SubwayStationLineType e : values()) {
			if(e.getKey().equals(key)) {
				return e.getTerminusStationName();
			}
		}
		return null;
	}

}
