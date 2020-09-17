package com.resourcing.service.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;

@Configuration
public class XrayConfig {

	@Bean
	public Filter TracingFilter() {
	    return new AWSXRayServletFilter("resourcing-service");
	}
	
}
