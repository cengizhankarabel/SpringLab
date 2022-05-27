package com.karabel;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.karabel.config.TransferServiceConfiguration;
import com.karabel.service.TransferService;

public class Application {
	public static void main(String[] args) {

		// -----------------------------------
		// boot/initialization phase
		// -----------------------------------

		System.out.println("-".repeat(50));

		ConfigurableApplicationContext applicationContext = null;
		applicationContext = new AnnotationConfigApplicationContext(TransferServiceConfiguration.class);

		System.out.println("-".repeat(50));

		// -----------------------------------
		// Use
		// -----------------------------------

		TransferService transferService = applicationContext.getBean(TransferService.class);
		transferService.transfer(100.00, "1", "2");

		// -----------------------------------
		// Destroy phase
		// -----------------------------------

	}
}
