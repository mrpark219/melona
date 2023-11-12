package com.park.melona.domain.subwayStation;

import com.park.melona.global.config.EnumModel;

public enum SubwayStationLineType implements EnumModel {

	LINE_1001("1호선"),
	LINE_1002("2호선"),
	LINE_1003("3호선"),
	LINE_1004("4호선"),
	LINE_1005("5호선"),
	LINE_1006("6호선"),
	LINE_1007("7호선"),
	LINE_1008("8호선"),
	LINE_1009("9호선"),
	LINE_1061("중앙선"),
	LINE_1063("경의중앙선"),
	LINE_1065("공항철도"),
	LINE_1067("경춘선"),
	LINE_1075("수의분당선"),
	LINE_1077("신분당선"),
	LINE_1092("우이신설선"),
	LINE_1093("서해선"),
	LINE_1081("경강선");

	private final String value;

	SubwayStationLineType(String value) {
		this.value = value;
	}

	@Override
	public String getKey() {
		return name();
	}

	@Override
	public String getValue() {
		return value;
	}

}
