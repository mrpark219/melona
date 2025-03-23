package com.park.melona.domain.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {

	@GetMapping("/write")
	public String reportWrite() {

		return "report/write";
	}

}
