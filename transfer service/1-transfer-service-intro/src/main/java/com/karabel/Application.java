package com.karabel;

import com.karabel.repository.AccountRepository;
import com.karabel.repository.JdbcAccountRepository;
import com.karabel.repository.JpaAccountRepository;
import com.karabel.service.TransferService;
import com.karabel.service.TransferServiceImpl;

public class Application {
	public static void main(String[] args) {

		// init / boot phase
		AccountRepository jdbcAccountRepository = new JdbcAccountRepository();
		AccountRepository jpaAccountRepository = new JpaAccountRepository();
		TransferService transferService = new TransferServiceImpl(jdbcAccountRepository);

		// use phase
		transferService.transfer(300, "1", "2");
		System.out.println();
		transferService.transfer(300, "1", "2");

		// destroy phase
		transferService = null;
	}
}
