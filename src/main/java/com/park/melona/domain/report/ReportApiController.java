package com.park.melona.domain.report;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportApiController {

	private final ReportService reportService;

	public ReportApiController(ReportService reportService) {
		this.reportService = reportService;
	}

	@PostMapping("")
	public Integer save(@Valid @RequestBody ReportSaveRequest reportSaveRequest) {

		return reportService.insertReport(reportSaveRequest);
	}

}
