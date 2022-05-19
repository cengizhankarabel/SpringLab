package com.karabel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(value = { JpaConfiguration.class })
@ComponentScan(basePackages = { "com.karabel" })
@EnableTransactionManagement
public class TransferServiceConfiguration {

	// @Bean
}
