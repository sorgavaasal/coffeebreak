package com.example.java7;

public class MultiThreadingThruAn {

	public void makeAndRunAnInnerThread() {
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; ++i) {
					System.out.println("Hello world thru another thread");
					System.out.println(Thread.currentThread());
				}
			}
		};
		System.out.println(Thread.currentThread());
		new Thread(runnable).start();
		System.out.println("end of Main");
	}
	
	public static void main(String[] args) {
		new MultiThreadingThruAn().makeAndRunAnInnerThread();
	}
}
