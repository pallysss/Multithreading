package com.ply.implementrunnable;

import com.ply.implementrunnable.Hello;
import com.ply.implementrunnable.Hi;

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

	public static void main(String[] args) {
		Hi hi = new Hi();
		Hello hello = new Hello();
		
		Thread thread1 = new Thread(hi);
		Thread thread2 = new Thread(hello);
		
		thread1.start();
		thread2.start();

	}

}
