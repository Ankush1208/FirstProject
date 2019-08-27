package com.string.example;


public class Threads implements  Runnable {
	Threads t1=new Threads();
	static int i=1;
	public void run() {
		System.out.println(i++);
	}
	public static void main(String...a)
	{
		Threads t1=new Threads();
		System.out.println(t1);
		Thread t2=new Thread(new Threads());
		t2.run();
		t2.run();
		t2.start();
	}
}
