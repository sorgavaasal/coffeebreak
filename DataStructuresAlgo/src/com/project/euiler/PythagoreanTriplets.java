package com.project.euiler;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/***
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
problem number 9
 * @author srividhya
 *
 */
public class PythagoreanTriplets {
	
	public static void genPythTriplets() {
		
		Stream<int[]> pythoagoreanTriplets = 
				IntStream.rangeClosed(0, 1000).boxed().
				flatMap(a -> IntStream.rangeClosed(a, 1000).
						filter(b -> Math.sqrt(a*a+b*b) % 1 == 0).
						mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a*a + b*b)}))
				.filter(t -> t[0] + t[1] + t[2] == 1000);
		
		//pythoagoreanTriplets.forEach(t -> System.out.println(t[0] + "===" + t[1] + "===" + t[2]));
		pythoagoreanTriplets
				.forEach(t -> System.out.println(t[0] * t[1] * t[2] + " " + t[0] + " " + t[1] + " " + t[2]));
		
	}
	
	public static void main(String[] args) {
		genPythTriplets();
	}

}
