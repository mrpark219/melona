package com.park.melona.global.config;

import com.park.melona.domain.subwayStation.SubwayStationLineType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnumConfig {

	@Bean
	public EnumMapper enumMapper() {
		EnumMapper enumMapper = new EnumMapper();

		enumMapper.put("SubwayStationLineType", SubwayStationLineType.class);

		return enumMapper;
	}

}
