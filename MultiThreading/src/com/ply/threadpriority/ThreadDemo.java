package com.ply.threadpriority;

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
		Thread thread1 = new Thread(hi ,"Hi Thread");
		Thread thread2 = new Thread(hello);
		thread2.setName("Hello Thread");
		
		//set the priority (scale 1 to 10)
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(7);
		
		System.out.println("Thread 1 Priority > "+thread1.getPriority());
		System.out.println("Thread 2 Priority > "+thread2.getPriority());
		
		thread1.start();
		thread2.start();

	}

}
