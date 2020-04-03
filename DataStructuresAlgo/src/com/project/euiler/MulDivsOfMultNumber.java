package com.project.euiler;

public class MulDivsOfMultNumber {
	
	public static void main(String[] args) {
		Integer num1 = 3;
		Integer num2 = 5;
		Integer sum = 0;
		
		for  (int i=0; i < 1000; ++i) {
			if (i % num1 == 0 || i % num2 == 0) {
				sum = sum + i;
			}
		}
		
		System.out.println(" sum of all multiples of 3 and 5 within10 " + sum);
			
	}

}
