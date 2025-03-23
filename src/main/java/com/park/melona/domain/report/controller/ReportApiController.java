package com.park.melona.domain.report.controller;

import com.park.melona.domain.report.request.ReportSaveRequest;
import com.park.melona.domain.report.response.ReportSaveResponse;
import com.park.melona.domain.report.service.ReportService;
import com.park.melona.global.response.ApiResponse;
import com.park.melona.global.util.WebUtil;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/report")
public class ReportApiController {

	private final ReportService reportService;

	public ReportApiController(ReportService reportService) {
		this.reportService = reportService;
	}

	@PostMapping("")
	public ApiResponse<ReportSaveResponse> save(@Valid @RequestBody ReportSaveRequest reportSaveRequest) {

		return ApiResponse.ok(reportService.insertReport(reportSaveRequest.toServiceRequest(), WebUtil.getIpAddress(), LocalDateTime.now()));
	}

}
