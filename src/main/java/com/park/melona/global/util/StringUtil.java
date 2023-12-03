package com.park.melona.global.util;

public class StringUtil {

	/**
	 * 초 정보를 보기 좋게 가공하는 메서드
	 * @param seconds 초
	 * @return 가공된 시간 정보
	 */
	public static String convertSecondsToTimeString(long seconds) {

		if(seconds < 0) {
			return "";
		}

		long hours = seconds / 3600;
		long minutes = (seconds % 3600) / 60;
		long remainingSeconds = seconds % 60;

		StringBuilder result = new StringBuilder();
		if(hours > 0) {
			result.append(hours).append("시 ");
		}
		if(minutes > 0) {
			result.append(minutes).append("분 ");
		}
		result.append(remainingSeconds).append("초");

		return result.toString();
	}

}
