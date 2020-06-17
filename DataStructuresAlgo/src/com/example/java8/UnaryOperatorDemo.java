package com.example.java8;

public class UnaryOperatorDemo {

	public static void main(String[] args) {
		int x = 3;
		int y = ++x * 5 / x-- + --x;
		System.out.println("final result x ===" +x);
		System.out.println("final result y ===" +y);
		
		short a = 100;
		short b = 200;
		//short c =  a + b;
		
	}
}
