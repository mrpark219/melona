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

	public SubwayStation selectSubwayStationByStationId(Integer stationId) {
		return dslContext
				.fetchSingle(SUBWAY_STATION, SUBWAY_STATION.STATION_ID.eq(stationId))
				.into(SubwayStation.class);
	}

	public List<SubwayStation> selectPreviousSubwayStation(Integer stationId) {
		return dslContext
				.select(SUBWAY_STATION.as("ss2").STATION_ID, SUBWAY_STATION.as("ss2").SUBWAY_ID,
						SUBWAY_STATION.as("ss2").STATION_NAME, SUBWAY_STATION.as("ss2").PREVIOUS_STATION_ID,
						SUBWAY_STATION.as("ss2").FR_CODE)
				.from(SUBWAY_STATION.as("ss1"))
				.join(SUBWAY_STATION.as("ss2"))
				.on(SUBWAY_STATION.as("ss1").PREVIOUS_STATION_ID.eq(SUBWAY_STATION.as("ss2").STATION_ID)
						.and(SUBWAY_STATION.as("ss1").STATION_ID.eq(stationId)))
				.fetch()
				.into(SubwayStation.class);
	}

	public List<SubwayStation> selectNextSubwayStation(Integer stationId) {
		return dslContext
				.select(SUBWAY_STATION.STATION_ID, SUBWAY_STATION.SUBWAY_ID, SUBWAY_STATION.STATION_NAME,
						SUBWAY_STATION.PREVIOUS_STATION_ID, SUBWAY_STATION.FR_CODE)
				.from(SUBWAY_STATION)
				.where(SUBWAY_STATION.PREVIOUS_STATION_ID.eq(stationId))
				.fetch()
				.into(SubwayStation.class);
	}
}
