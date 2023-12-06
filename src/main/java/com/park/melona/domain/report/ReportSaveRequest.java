package com.park.melona.domain.report;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReportSaveRequest {

	@NotBlank
	private String title;

	@NotBlank
	private String content;

}
