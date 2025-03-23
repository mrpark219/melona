package com.park.melona.domain.report.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReportSaveRequest {

	@NotBlank
	private String title;

	@NotBlank
	private String content;

	@Builder
	public ReportSaveRequest(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public ReportSaveServiceRequest toServiceRequest() {
		return ReportSaveServiceRequest.builder()
			.title(title)
			.content(content)
			.build();
	}
}
