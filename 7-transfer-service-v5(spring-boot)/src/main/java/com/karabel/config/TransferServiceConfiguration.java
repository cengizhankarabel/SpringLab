package com.karabel.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.karabel" })
@EntityScan(value = {"com.karabel.entity"})
@EnableJpaRepositories(basePackages = {"com.karabel.repository"})
@EnableTransactionManagement
public class TransferServiceConfiguration {

	// @Bean
}
