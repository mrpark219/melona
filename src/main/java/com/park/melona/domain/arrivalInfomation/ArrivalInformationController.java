package com.park.melona.domain.arrivalInfomation;

import com.park.melona.domain.subwayStation.SubwayStationLineType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/arrival-information")
public class ArrivalInformationController {

	private final ArrivalInformationService arrivalInformationService;

	public ArrivalInformationController(ArrivalInformationService arrivalInformationService) {
		this.arrivalInformationService = arrivalInformationService;
	}

	@GetMapping("/{subwayId}/{stationId}")
	public String arrivalInformation(@PathVariable String subwayId, @PathVariable Integer stationId, Model model) {

		ArrivalInformationResponse arrivalInformationResponse = arrivalInformationService.selectArrivalInformation(subwayId, stationId);

		SubwayStationLineType subwayStationLineType = SubwayStationLineType.valueOf(subwayId);

		model.addAttribute("arrivalInformationResponse", arrivalInformationResponse);
		model.addAttribute("subwayStationLineType", subwayStationLineType);

		return "arrivalInformation/arrivalInformation";
	}


}
