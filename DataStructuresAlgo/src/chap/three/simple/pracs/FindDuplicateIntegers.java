package chap.three.simple.pracs;

import java.util.Arrays;

/***
 * Algorithm for finding the duplicate items in
 * the array 
 * @author Sridhar Raman
 *
 */
public class FindDuplicateIntegers {
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public int[] extractDups(int[] input) {
		
		int[] outputArray = new int[input.length];		
		for (int i=0; i < input.length; ++i) {
		    addDupsInt(input[i], outputArray);	
		}
		return outputArray;
	}
	
	private void addDupsInt(int input, int[] dupsCont) {
		if (dupsCont.length == 0) return;
		
		int finalInt = 0;
		for (int j=0; j < dupsCont.length; ++j) {
			if (dupsCont[j] == input) {
				return;
			}
			finalInt = j;
		}
		
		dupsCont[++finalInt] = input;
	}

	public static void main(String[] args) {
		FindDuplicateIntegers dupsFinder = new FindDuplicateIntegers();
		int[] inputArrayInteger = {1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10, 11, 11, 12, 13, 13, 14, 15, 15};
		int[] dupsArray = dupsFinder.extractDups(inputArrayInteger);
		Arrays.stream(dupsArray).forEach(System.out::println);
	}
}
