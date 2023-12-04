package com.park.melona.domain.congestion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/congestion")
public class CongestionApiController {

	private final CongestionService congestionService;

	public CongestionApiController(CongestionService congestionService) {
		this.congestionService = congestionService;
	}

	@GetMapping("/{subwayId}/{trainNo}")
	public CongestionResponse congestion(@PathVariable String subwayId, @PathVariable Long trainNo) {

		return congestionService.selectCongestion(subwayId, trainNo);
	}

}
