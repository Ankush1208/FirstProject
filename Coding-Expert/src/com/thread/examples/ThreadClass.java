package com.thread.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadClass {

	private static int counter=0;
	public static void main(String[] args) throws InterruptedException {
		
	/*	new Thread(()->{
			for (int i=0;i<500;i++) counter++;
		}).start();

		while(counter<100)
		{
			System.out.println("not reached");
			Thread.sleep(1000);
		}
		System.out.println("reached");*/
		
		ExecutorService service=null;
		try{
			service=Executors.newSingleThreadExecutor();
			System.out.println("begin");
			service.execute(()->System.out.println("entergin zoo"));
			service.execute(()-> {for(int i=0;i<3;i++)
				System.out.println("printing zoo");});
			System.out.println("leaving");
			
		}finally{
			if(service!=null)
service.shutdown();
			}
		
	}

}
