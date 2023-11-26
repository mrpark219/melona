package com.park.melona.domain.subwayStation;

import jooq.gernated.tables.pojos.SubwayStation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lines")
public class SubwayStationLineController {

	private final SubwayStationLineService subwayStationLineService;

	public SubwayStationLineController(SubwayStationLineService subwayStationLineService) {
		this.subwayStationLineService = subwayStationLineService;
	}

	@GetMapping("")
	public String lineList(Model model) {

		List<SubwayStationLineListResponse> subwayStationLineListResponseList = subwayStationLineService.selectSubwayStationLineList();
		model.addAttribute("subwayStationLineListResponseList", subwayStationLineListResponseList);

		return "subwayLine/subwayLineList";
	}

	@GetMapping("/{subwayStationLine}")
	public String subwayStationListByLineNumber(@PathVariable String subwayStationLine, Model model) {

		SubwayStationLineType subwayStationLineType = SubwayStationLineType.valueOf(subwayStationLine);

		List<SubwayStation> subwayStationList = subwayStationLineService.selectSubwayStationListByLineNumber(subwayStationLine);

		model.addAttribute("subwayStationLineType", subwayStationLineType);
		model.addAttribute("subwayStationList", subwayStationList);

		return "subwayLine/subwayLine";
	}

}
