package com.karabel.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(name="com.karabel.TodosService")
public class CengizhanAutoConfiguration {
	
	@Bean
	public String bean1() {
		return "BEAN-1";
	}
	
	@Bean
	public String bean2() {
		return "BEAN-2";
	}
	
}
