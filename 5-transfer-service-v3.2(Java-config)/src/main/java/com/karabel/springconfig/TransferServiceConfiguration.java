package com.karabel.springconfig;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.karabel" })
public class TransferServiceConfiguration {

	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/bankdb");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("admin");
		basicDataSource.setMaxTotal(15);
		return basicDataSource;
	}

}
