package com.xworkz.flight.constants;

public enum JdbcProperties {

	URL("jdbc:mysql://localhost:3306/shivamogga"), USERNAME("root"), SECRET("Xworkzodc@123");

	private String value;

	private JdbcProperties(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
