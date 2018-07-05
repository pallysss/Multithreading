package com.ply.interthreadcommunication;

class Test {
	boolean valueSet = false;
	int number;
	
	public synchronized void set(int number) {
		if (valueSet) {
			try {
				wait(); // wait state until get executed
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		valueSet = true;
		System.out.println("Set " +number);
		this.number = number;
		notify(); //notify set is finish and will executed get next
	}
	
	public synchronized int get() {
		if (!valueSet) {
			try {
				wait(); // wait state until set executed
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		valueSet = false;
		System.out.println("GET "+number);
		notify(); //notify get is finish and will executed set next
		return number;
	}
}

class Producer implements Runnable {
	Test test;
	
	public Producer(Test test) {
		this.test = test;
		Thread tProd = new Thread(this , "Thread Producer");
		tProd.start();
	}

	public void run() {
		int i=0;
		while (true) {
			test.set(i++);
			//System.out.println(test.number);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	Test test ;
	

	public Consumer(Test test) {
		this.test = test;
		Thread tCons = new Thread(this, "Thread Consumer");
		tCons.start();
	}

	public void run() {
		while (true) {
			test.get();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		Test test = new Test();
		new Producer(test);
		new Consumer(test);

	}

}
