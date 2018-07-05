package com.ply.synckeyword;

class Counter {
	int counter;
	
	/**
	 * sync modifier >> only one thread can execute this method
	 * prevent this method executed at the same time
	 * delete sync to see the difference
	 */
	public synchronized void increment() {
		counter++;
	}
}

public class ThreadDemo {

	public static void main(String[] args) throws Exception {
		Counter c = new Counter();
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i=0 ; i<1000; i++) {
					c.increment();
				}
				
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i=0 ; i<1000; i++) {
					c.increment();
				}
				
			}
		});
		
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println("Counter = "+c.counter);

	}

}
