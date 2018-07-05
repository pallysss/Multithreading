package com.ply.joinandisalive;

import com.ply.joinandisalive.Hello;
import com.ply.joinandisalive.Hi;

class Hi implements Runnable{
	
	public void run() {
		for (int i=0 ; i<5 ; i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Hello implements Runnable {
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
}

public class ThreadDemo {

	public static void main(String[] args) throws Exception {
		Hi hi = new Hi();
		Hello hello = new Hello();
		
		Thread thread1 = new Thread(hi);
		Thread thread2 = new Thread(hello);
		System.out.println("Thread1 = >"+thread1.getName());
		System.out.println("Thread2 = >"+thread2.getName());
		System.out.println("Main Thread = >"+Thread.currentThread().getName());
		
		thread1.start();
		System.out.println("Thread1 Status ="+thread1.isAlive()); // check the status of thread1 after start
		Thread.sleep(10);
		thread2.start();
		
		thread1.join(); //join wait this thread to die
		thread2.join();
		System.out.println("Thread1 Status ="+thread1.isAlive()); // check the status of thread1 after join
		/**
		 * Bye will be hadled by main Thread and 'll waiting until thread1 and thread2 executed because the join function
		 */
		System.out.print("Bye");

	}

}

