package com.park.melona.domain.report.service;

import com.park.melona.domain.report.Report;
import com.park.melona.domain.report.repository.ReportRepository;
import com.park.melona.domain.report.request.ReportSaveServiceRequest;
import com.park.melona.domain.report.response.ReportSaveResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class ReportService {

	private final ReportRepository reportRepository;

	public ReportService(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}

	public ReportSaveResponse insertReport(ReportSaveServiceRequest reportSaveServiceRequest, String ipAddress, LocalDateTime registrationDateTime) {

		Report report = Report.create(reportSaveServiceRequest.getTitle(), reportSaveServiceRequest.getContent(), ipAddress, registrationDateTime);

		report = reportRepository.insertReport(report);

		return ReportSaveResponse.of(report);
	}
}
