package chap.five.simple.pracs;

import java.util.Arrays;

/***
 * Rearrange all even numbers to the beginning of the array
 * @author srividhya
 *
 */
public class RearrangeArrayRecurssive {
	
	private static void regarrangeArray(int[] input, int[] output, int low, int olow, int ohigh) {
		if (low > input.length-1) {
			return;
		} else {
			if (input[low] % 2 == 0) { 
				output[olow] = input[low];
				olow++;
			}
			if (input[low] % 2 != 0) {
				output[ohigh] = input[low];
			    ohigh--;
			}
			low++;
			regarrangeArray(input, output, low, olow, ohigh);
		}
		
	}
	
	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		int[] output = new int[input.length];
		regarrangeArray(input, output,  0, 0, input.length-1);
		Arrays.stream(output).forEach(n -> {System.out.print(n + " ");});
	}

}
