package com.project.euiler;

public class FibonacciRecurssive {

	private static Integer calculateNextNum(int currNum, int prevNum, int nextNum) {
		nextNum = prevNum + currNum;
		prevNum = currNum;
		currNum = nextNum;

		if (nextNum < 55) {
			calculateNextNum(currNum, prevNum, nextNum);
		}

		return nextNum;
	}

	public static void main(String[] args) {
		int currNum = 1;
		int prevNum = 0;
		int nextNum = 0;
		System.out.println("Fibonacci result in recussive " + calculateNextNum(currNum, prevNum, nextNum));

	}

}
