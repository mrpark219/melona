package com.park.melona.domain.subwayStation;

import jooq.gernated.tables.pojos.SubwayStation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lines")
public class SubwayStationLineApiController {

	private final SubwayStationLineService subwayStationLineService;

	public SubwayStationLineApiController(SubwayStationLineService subwayStationLineService) {
		this.subwayStationLineService = subwayStationLineService;
	}

	@GetMapping("")
	public List<SubwayStationLineListResponse> lineList() {

		return subwayStationLineService.selectSubwayStationLineList();
	}

	@GetMapping("/{subwayStationLine}")
	public List<SubwayStation> subwayStationListByLineNumber(@PathVariable String subwayStationLine) {

		return subwayStationLineService.selectSubwayStationListByLineNumber(subwayStationLine);
	}

}
