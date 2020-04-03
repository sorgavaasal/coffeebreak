package com.example.common.classes;

public class Transaction {
	
	public Transaction (Trader trader, int year, int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	private final Trader trader;
	private final Integer year;
	private final Integer value;

	public Trader getTrader() {
		return trader;
	}
	public Integer getYear() {
		return year;
	}
	public Integer getValue() {
		return value;
	}
	
}
