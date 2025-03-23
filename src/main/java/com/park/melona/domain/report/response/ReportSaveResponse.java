package com.park.melona.domain.report.response;

import com.park.melona.domain.report.Report;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReportSaveResponse {

	private Long id;
	private String title;
	private String content;
	private String ip;
	private LocalDateTime registrationDate;

	public ReportSaveResponse() {
	}

	@Builder
	public ReportSaveResponse(Long id, String title, String content, String ip, LocalDateTime registrationDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.ip = ip;
		this.registrationDate = registrationDate;
	}

	public static ReportSaveResponse of(Report report) {
		return builder()
			.id(report.getId())
			.title(report.getTitle())
			.content(report.getContent())
			.ip(report.getIp())
			.registrationDate(report.getRegistrationDate())
			.build();
	}
}
