package com.project.euiler;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberLocationLimit {
	
	public static boolean isNumPrime(long num) {
		if (num == 0 || num == 1)
			return false;
		
		for (int i=2; i<num; ++i) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		List<Integer> primeNumList = new ArrayList<>();
		int limit = 10001;
		int startNum = 0;
		int j = 0;
		
		
		while (j < limit) {
			++startNum;
			if (isNumPrime(startNum)) {
				primeNumList.add(startNum);
				++j;
			} else {
				continue;
			}
		
		}
		
		System.out.println(primeNumList.get(primeNumList.size()-1));
		long endTime = System.nanoTime();
		long timeTaken = endTime - startTime;
		System.out.println("in milliSec" +timeTaken);
		System.out.println("in milliSec" +timeTaken/1000000L);
	
	}

}
