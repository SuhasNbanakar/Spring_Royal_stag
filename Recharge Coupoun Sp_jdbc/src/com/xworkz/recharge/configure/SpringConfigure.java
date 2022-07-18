package com.xworkz.recharge.configure;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.xworkz.recharge")
public class SpringConfigure {

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource managerDataSource = new DriverManagerDataSource(
				"jdbc:mysql://localhost:3306/shivamogga", "root", "Xworkzodc@123");

		return managerDataSource;
	}

}
