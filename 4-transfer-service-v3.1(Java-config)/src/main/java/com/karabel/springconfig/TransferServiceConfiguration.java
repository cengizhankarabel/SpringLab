package com.karabel.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.karabel.repository.AccountRepository;
import com.karabel.repository.JdbcAccountRepository;
import com.karabel.repository.JpaAccountRepository;
import com.karabel.service.TransferService;
import com.karabel.service.TransferServiceImpl;

@Configuration
public class TransferServiceConfiguration {

	@Bean
	public AccountRepository jdbcAccountRepository() {
		return new JdbcAccountRepository();
	}

	@Bean
	public AccountRepository jpaAccountRepository() {
		return new JpaAccountRepository();
	}

	@Bean
	public TransferService transferService() {
		return new TransferServiceImpl(jdbcAccountRepository());
	}
}
