package com.example.java8;

/**
 * Tutorials point example for Lamda expression 
 * @author srividhya
 *
 */

public class SimpleLambdas {
	
/**
 * Match operation example 
 * @param args
 */
public static void main(String[] args) {
	
	SimpleLambdas simpleLambdas = new SimpleLambdas();
	
	//Simple example of lamda expression 
	//addition operation
	MathOperation addition = (int a, int b) -> a + b;
	//System.out.println(addition.operate(4, 5));
	System.out.println(simpleLambdas.operate(5, 6, addition));
	
	//subtraction operation 
	MathOperation subtraction = (a, b) -> a - b;
	System.out.println(simpleLambdas.operate(9, 5, subtraction));
	
	//multiplication operation 
	MathOperation multiplication = (a , b) -> { return a * b; };
	System.out.println(simpleLambdas.operate(9, 8, multiplication));
	
	//Division operation
	MathOperation division = (int a, int b) -> a / b;
	System.out.println(simpleLambdas.operate(15, 3, division));
	
}	

interface MathOperation {
	int operate(int a, int b);
}

private int operate(int a, int b, MathOperation operation) {
	return operation.operate(a, b);
}


}
