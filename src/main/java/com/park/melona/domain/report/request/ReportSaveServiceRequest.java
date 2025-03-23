package com.park.melona.domain.report.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ReportSaveServiceRequest {

	@NotBlank
	private String title;

	@NotBlank
	private String content;

	@Builder
	public ReportSaveServiceRequest(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
