package com.park.melona.domain.arrivalInfomation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/arrival-information")
public class ArrivalInformationApiController {

	private final ArrivalInformationService arrivalInformationService;

	public ArrivalInformationApiController(ArrivalInformationService arrivalInformationService) {
		this.arrivalInformationService = arrivalInformationService;
	}

	@GetMapping("/{subwayId}/{stationId}")
	public ArrivalInformationResponse arrivalInformation(@PathVariable String subwayId, @PathVariable Integer stationId) {

		return arrivalInformationService.selectArrivalInformation(subwayId, stationId);
	}

}
