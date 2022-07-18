package com.xworkz.resort.configure;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.xworkz.resort")
public class SpringConfigure {

	@Bean
	public DataSource datSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306?shivamogga",
				"root", "Xworkzodc@123");
		return dataSource;
	}
}
