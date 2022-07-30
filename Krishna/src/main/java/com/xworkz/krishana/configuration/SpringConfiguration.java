package com.xworkz.krishana.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.krishana")
@EnableWebMvc
public class SpringConfiguration {

	public SpringConfiguration() {
		System.out.println("create a spring configuration");
	}

}
