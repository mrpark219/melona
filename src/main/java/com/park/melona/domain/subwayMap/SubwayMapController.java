package com.park.melona.domain.subwayMap;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subway-map")
public class SubwayMapController {

	@GetMapping("")
	public String subwayMap() {

		return "subwayMap/subwayMap";
	}

}
