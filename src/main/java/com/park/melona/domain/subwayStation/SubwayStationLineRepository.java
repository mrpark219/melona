package com.park.melona.domain.subwayStation;

import jooq.gernated.tables.pojos.SubwayStation;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jooq.gernated.Tables.SUBWAY_STATION;

@Repository
public class SubwayStationLineRepository {

	private final DSLContext dslContext;

	public SubwayStationLineRepository(DSLContext dslContext) {
		this.dslContext = dslContext;
	}

	public List<SubwayStation> selectSubwayStationListByLineNumber(Integer subwayStationLine) {
		return dslContext
				.select(SUBWAY_STATION.STATION_ID, SUBWAY_STATION.SUBWAY_ID, SUBWAY_STATION.STATION_NAME,
						SUBWAY_STATION.PREVIOUS_STATION_ID, SUBWAY_STATION.FR_CODE)
				.from(SUBWAY_STATION)
				.where(SUBWAY_STATION.SUBWAY_ID.eq(subwayStationLine))
				.orderBy(SUBWAY_STATION.FR_CODE)
				.fetch()
				.into(SubwayStation.class);
	}
}
