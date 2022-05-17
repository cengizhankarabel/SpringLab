package com.karabel;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.karabel.repository.AccountRepository;
import com.karabel.repository.JdbcAccountRepository;
import com.karabel.repository.JpaAccountRepository;
import com.karabel.service.TransferService;
import com.karabel.service.TransferServiceImpl;

public class Application {
	public static void main(String[] args) {

		// init / boot phase
//		AccountRepository jdbcAccountRepository = new JdbcAccountRepository();
//		AccountRepository jpaAccountRepository = new JpaAccountRepository();
//		TransferService transferService = new TransferServiceImpl(jdbcAccountRepository);

		ConfigurableApplicationContext applicationContext = null;
		applicationContext = new ClassPathXmlApplicationContext("transfer-service.xml");

		System.out.println("-".repeat(50));

		// use phase
		TransferService transferService = applicationContext.getBean("transferService", TransferService.class);
		transferService.transfer(300.00, "1", "2");
		System.out.println("-".repeat(25));
		transferService.transfer(300.00, "1", "2");

		// destroy phase
		applicationContext.close();
	}
}
