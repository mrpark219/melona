package com.park.melona.domain.subwayStation;

import com.park.melona.global.config.EnumMapper;
import com.park.melona.global.config.EnumValue;
import jooq.gernated.tables.pojos.SubwayStation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SubwayStationLineService {

	private final SubwayStationLineRepository subwayStationLineRepository;

	private final EnumMapper enumMapper;

	public SubwayStationLineService(SubwayStationLineRepository subwayStationLineRepository, EnumMapper enumMapper) {
		this.subwayStationLineRepository = subwayStationLineRepository;
		this.enumMapper = enumMapper;
	}

	/**
	 * 지하철 호선으로 지하철역 목록을 리턴
	 *
	 * @param subwayStationLine 지하철 호선
	 * @return 요청한 호선에 속한 지하철 목록
	 */
	public List<SubwayStation> selectSubwayStationListByLineNumber(String subwayStationLine) {

		Integer subwayStationLineInteger = Integer.valueOf(subwayStationLine.replace("LINE_", ""));

		return subwayStationLineRepository.selectSubwayStationListByLineNumber(subwayStationLineInteger);
	}

	/**
	 * 지하철 호선 목록 리턴
	 *
	 * @return 지하철 호선 목록
	 */
	public List<SubwayStationLineListResponse> selectSubwayStationLineList() {
		List<EnumValue> subwayStationLineType = enumMapper.get("SubwayStationLineType");

		return subwayStationLineType.stream()
				.map(enumValue -> SubwayStationLineListResponse.builder()
						.subwayLineId(enumValue.getKey())
						.subwayLineName(enumValue.getValue())
						.startingStationName(SubwayStationLineType.getStartingStationNameByKey(enumValue.getKey()))
						.terminusStationName(SubwayStationLineType.getTerminusStationNameByKey(enumValue.getKey()))
						.build())
				.collect(Collectors.toList());
	}
}
