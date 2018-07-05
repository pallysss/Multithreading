package com.ply.lambda;

import com.ply.lambda.Hello;


class Hello implements Runnable {
	public void run() {
		
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		/**
		 * Runnable implementation can use lambda expression because it is functional interface
		 */
		Runnable hi = () -> {
				for (int i=0 ; i<5 ; i++) {
					System.out.println("Hi");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			};
		
		Runnable hello = new Runnable() {		
			@Override
			public void run() {
				for (int i=0;i<5;i++) {
					System.out.println("Hello");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		/**
		 * instead using this, you can assign the hi object directly 
		 */
		Thread thread1 = new Thread(hi);
		Thread thread2 = new Thread(hello);
		
		thread1.start();
		thread2.start();

	}

}
