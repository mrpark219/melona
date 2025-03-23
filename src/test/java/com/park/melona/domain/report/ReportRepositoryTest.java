package com.park.melona.domain.report;

import com.park.melona.domain.report.repository.ReportRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ReportRepositoryTest {

	@Autowired
	private ReportRepository reportRepository;

	@DisplayName("신고를 등록합니다.")
	@Test
	void insertReport() {
	    
	    // given
		LocalDateTime registrationDate = LocalDateTime.now();

		Report report = Report.builder()
			.title("testTitle")
			.content("testContent")
			.ip("127.0.0.1")
			.registrationDate(registrationDate)
			.build();
		
	    // when
		Report savedReport = reportRepository.insertReport(report);

		// then
		assertThat(savedReport.getId()).isNotNull();
	}
}