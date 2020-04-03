package com.project.euiler;

public class LargetProductPalindrome {
	
	
	public static boolean isNumPalindrome(long num) {
		boolean condition = false;
		
		if (num < 0) {
			return condition;
		}
		
		long rem = 0;
		long rev = 0;
		long copy = num;
		
		
		while (num > 0) {
			rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}
		
		if (rev == copy) {
			condition = true;
		} else {
			condition = false;
		}
				
		return condition;
	}

	public static void main(String[] args) {
		int product = 0;
		int prevProduct = 0;
		int prevI = 0;
		int prevJ = 0;
		
		for (int i = 0; i < 1000; ++i) {
			for (int j = 0; j < 1000; ++j) {
				product = i * j;
				if (isNumPalindrome(product) && (product > prevProduct)) {
					prevProduct = product;
					if (i > prevI)
						prevI = i;
					if (j > prevJ) 
						prevJ = j;
				}
			}
		}
		
		System.out.println("largest 3 digits product " +prevProduct);
		System.out.println(" numbers in product " +prevI + " & " + prevJ);
	}
}
