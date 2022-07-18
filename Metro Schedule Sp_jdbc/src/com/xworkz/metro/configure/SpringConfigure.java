package com.xworkz.metro.configure;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.xworkz.metro")
public class SpringConfigure {
	@Bean
	public DataSource datasource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/shivamogga",
				"root", "Xworkzodc@123");

		return dataSource;
	}

}
