package com.park.melona.domain.report.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.park.melona.domain.report.request.ReportSaveRequest;
import com.park.melona.domain.report.service.ReportService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ReportApiController.class)
class ReportApiControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private ReportService reportService;

	@DisplayName("신고를 등록한다.")
	@Test
	void insertReport() throws Exception {

		// given
		ReportSaveRequest request = ReportSaveRequest.builder()
			.title("testTitle")
			.content("testContent")
			.build();

		// when then
		mockMvc.perform(
				post("/api/report")
					.content(objectMapper.writeValueAsString(request))
					.contentType(MediaType.APPLICATION_JSON)
			)
			.andDo(print())
			.andExpect(status().isOk());
	}
}