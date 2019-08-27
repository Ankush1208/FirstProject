package com.thread.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManager {

	public int counter=0;
	private synchronized void increment()
	{
		System.out.print(++counter +" ");
	}
	public static void main(String[] args) {

		ExecutorService service=null;
		SheepManager s1=new SheepManager();
		try
		{
			service=Executors.newSingleThreadExecutor();
			for(int i=0;i<10;i++)
		  service.execute(()->s1.increment() );
			
		}finally{
			if(service!=null)
				service.shutdown();
		}
	}

}
