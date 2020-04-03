package com.example.common.classes;

public class Trader {
	
	private final String name;
	private final String city;
	
	public Trader(String name, String city) {
		this.name = name;
		this.city = city;
	}
	
	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String toString() {
		return "Trader :" + this.getName() + " in " + this.getCity();
	}

}
