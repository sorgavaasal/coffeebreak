package com.project.euiler;

public class SmallestMultiple {
	
	public static void main(String[] args) {
	
		getSmallestMultple();
		
	}

	public static void getSmallestMultple () {
		
		int prevMultiple = 0;

		for (int i=Integer.MAX_VALUE; i>0; --i) {
			
			for (int j=1; j<=20; ++j) {
				int rem = i % j;
				if (rem != 0) {
					break;
				}
				
				if (j == 20) {
					prevMultiple = i;
					System.out.println("got prevMultiple " +prevMultiple);
				}
			}
		}
		
		System.out.println("smallest multiple divisible by 1 ~ 20 " +prevMultiple);
		
	}
}
