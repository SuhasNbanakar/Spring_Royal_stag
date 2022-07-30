package com.xworkz.ott.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.ott")
@EnableWebMvc
public class SpringConfiguration {

	public SpringConfiguration() {
		System.out.println("spring configuration is born..!");
	}

//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource source = new DriverManagerDataSource("jdbc:mysql://localhost:3306/shivamogga", "root",
//				"Xworkzodc@123");
//		return source;
//	}
}
