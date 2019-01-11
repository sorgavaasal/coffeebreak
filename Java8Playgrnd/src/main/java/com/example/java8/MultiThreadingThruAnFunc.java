package com.example.java8;

import java.util.function.Consumer;

/**
 * example of executing a functional interface 
 * runnable 
 * @author srividhya
 *
 */
public class MultiThreadingThruAnFunc {
	
	public void makeAndRunMultiThreading() {

		Runnable runnable = () -> {
			for (int i=0; i<100; ++i) {
				System.out.println("hello world through multithreading java8");
				System.out.println(Thread.currentThread());
			}
		};
		
		System.out.println(Thread.currentThread());
		new Thread(runnable).start();
		System.out.println("end of main thread");
		String s = "my name is Sridhar";
		Consumer<String> c = System.out::println;
		c.accept(s);
	}

	public static void main(String[] args) {
		new MultiThreadingThruAnFunc().makeAndRunMultiThreading();
	}
}
