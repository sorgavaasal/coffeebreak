package com.project.euiler;

public class PrimeFactors {
	
	/**
	 * 
	 * @param i
	 * @return
	 * Not a working program, it gets stuck with the huge number 
	 * Best solution from Euler alogrithm site 
	 * 
	 * public class Euler {

	public static void main(String[] args) {
		double  n =600851475143.0;
		long m = (long) n;
		 System.out.println(foo(m));

}
	
	
	//finds biggest prime divisor of n
	public static long foo(long n) {
		
		long i = 3;
		while(n!=1) {
		while(n%i!=0) {
			i++;
		}
		n=n/i;
		}
		return i;
	}
	
}
	 */
	public boolean isNumPrime(long num) {
		for (long i=1; i < num; ++i) {
			if (i == 1) 
				continue;
			
			if (num % i == 0) 
				return false;
			
		}		
		return true;
		
	}
	
	
	private long getLargestPrimeFactor(long inputNum) {

		long maxPrFac = 0;
		long result = 0;
		long originalNum = inputNum;
		for (long i = 1; i < originalNum; ++i) {
			if (i == 1) {
				continue;
			}
			result = inputNum % i;
			if (result == 0) {
				if (isNumPrime(i)) {
					System.out.println("Prime Factor " + i);
					if (i > maxPrFac) {
						maxPrFac = i;
					}
					
				    
				}	
				inputNum = inputNum / i;
				if (inputNum == 1) {
					break;
				}
			}

		}

		return maxPrFac;
	}

	/**
	 * LCM logic to find the largest prime factor 
	 * @param n
	 * @return
	 */
	public static long foo(long n) {

		long i = 3;
		while (n != 1) {
			while (n % i != 0) {
				i++;
			}
			if (new PrimeFactors().isNumPrime(i)) {
				System.out.println(" prime factor " +i);
			}
			n = n / i;
		}
		return i;
	}
	
	public static void main(String[] args) {
		Long sampleLong = 600851475143L;
		//Long sampleLong = 1000000L;
		//int length = sampleLong.toString().length();
		//long sampleLong = 13195;
		//System.out.println("is your number prime " +new PrimeFactors().isNumPrime(sampleLong));
		System.out.println(" your largest primeFactor " + new PrimeFactors().getLargestPrimeFactor(sampleLong));
		//System.out.println(foo(sampleLong));
	}

}
