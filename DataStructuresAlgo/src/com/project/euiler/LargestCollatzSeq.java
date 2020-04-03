package com.project.euiler;

import java.util.ArrayList;
import java.util.List;


/***
 * The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million
problem number 14 in Euiler 
 * @author srividhya
 *
 */
public class LargestCollatzSeq {

	private static void generateCollatzSeq() {
		
		long largestSeqSize = 0;
		long prevLargestNum = 0;
		for (long i=2; i < 1000000; ++i) {
			List<Long> collatzSeqList = new ArrayList<>();
			long result = 0;
			long num = i;
			
			while (true) {
				if (num%2 == 0) {
					result = num / 2;
					collatzSeqList.add(result);
				} else {
					result = (3 * num) + 1;
					collatzSeqList.add(result);
				}
				if (result <= 1)
					break;
				num = result;
			}
			
			if (collatzSeqList.size() > largestSeqSize) {
				largestSeqSize = collatzSeqList.size();
				prevLargestNum = i;
			}
			//System.out.println("number ===> " + i + " seq size " +collatzSeqList.size() + " List " + collatzSeqList);
		}
		
		System.out.println(" Largest collatz size " + largestSeqSize + " and the number " +prevLargestNum);
		
	}
	
	public static void main(String[] args) {
		generateCollatzSeq();
	}
}
