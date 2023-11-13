package com.park.melona.global.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder
				.requestFactory(() ->
						new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory())
				)
				.setConnectTimeout(Duration.ofMillis(500000))
				.setReadTimeout(Duration.ofMillis(500000))
				.build();
	}
}
