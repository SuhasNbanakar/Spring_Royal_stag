package com.xworkz.ott.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FrontControllerConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {

	private Class[] configClass = { SpringConfiguration.class };
	private String[] mappings = { "*.do" };

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("configuration is born..!");
		return configClass;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("mapping is born..!");
		return mappings;
	}

}
