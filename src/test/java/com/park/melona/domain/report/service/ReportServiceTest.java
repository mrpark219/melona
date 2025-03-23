package com.park.melona.domain.report.service;

import com.park.melona.domain.report.request.ReportSaveServiceRequest;
import com.park.melona.domain.report.response.ReportSaveResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ReportServiceTest {

	@Autowired
	private ReportService reportService;

	@DisplayName("새로운 신고하기 글을 등록한다.")
	@Test
	void insertReport() {

		// given
		String ipAddress = "127.0.0.1";
		LocalDateTime registrationDateTime = LocalDateTime.now();

		ReportSaveServiceRequest reportSaveServiceRequest = ReportSaveServiceRequest.builder()
			.title("testTitle")
			.content("testContent")
			.build();

		// when
		ReportSaveResponse reportSaveResponse = reportService.insertReport(reportSaveServiceRequest, ipAddress, registrationDateTime);

		// then
		assertThat(reportSaveResponse.getId()).isNotNull();
		assertThat(reportSaveResponse)
			.extracting("ip", "registrationDate")
			.contains(ipAddress, registrationDateTime);
	}

}