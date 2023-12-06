package com.park.melona.domain.report;

import com.park.melona.global.util.WebUtil;
import jooq.gernated.tables.pojos.Report;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReportService {

	private final ReportRepository reportRepository;

	public ReportService(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}

	public Integer insertReport(ReportSaveRequest reportSaveRequest) {

		Report report = new Report(null, reportSaveRequest.getTitle(), reportSaveRequest.getContent(), WebUtil.getIpAddress(), LocalDateTime.now());

		return reportRepository.insertReport(report);
	}
}
