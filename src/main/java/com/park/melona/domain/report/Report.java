package com.park.melona.domain.report;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class Report {

	@Setter
	private Long id;
	private String title;
	private String content;
	private String ip;
	private LocalDateTime registrationDate;

	public Report() {
	}

	@Builder
	public Report(Long id, String title, String content, String ip, LocalDateTime registrationDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.ip = ip;
		this.registrationDate = registrationDate;
	}

	public static Report create(String title, String content, String ip, LocalDateTime registrationDate) {
		return builder()
			.title(title)
			.content(content)
			.ip(ip)
			.registrationDate(registrationDate)
			.build();
	}
}
