package com.karabel.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.karabel.model.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("jdbcAccountRepository")
public class JdbcAccountRepository implements AccountRepository {
	
	// db-connection pool
	private DataSource dataSource;

	@Autowired
	public JdbcAccountRepository(DataSource dataSource) {
		this.dataSource = dataSource;
		log.info("JdbcAccountRepository instance created..");
	}

	public Account loadAccount(String number) {

		log.info("loading account.." + number);

		return new Account(number, 1000.00);
	}

	public void updateAccount(Account account) {

		log.info("updating account.." + account.getNumber());

	}

}