package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PingPongMain3{
	
	public static void main(String[] args) 
	{
		
		Runnable r1=new Runnable() 
		{
			@Override
			public void run()
			{
				for(int i=0;i<10;i++)
				{
					System.out.println("PING");
					try 
					{
						Thread.sleep(100);
					} 
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		
		Runnable r2=new Runnable() 
		{
			@Override
			public void run()
			{
				for(int i=0;i<10;i++)
				{
					System.out.println("\tPONG");
					try 
					{
						Thread.sleep(200);
					} 
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		
		Runnable r3=new Runnable() 
		{
			@Override
			public void run()
			{
				for(int i=0;i<10;i++)
				{
					System.out.println("\t\tTONG");
					try 
					{
						Thread.sleep(150);
					} 
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		
		ExecutorService e=Executors.newFixedThreadPool(3);
		e.submit(r1);
		e.submit(r2);
		e.submit(r3);
		e.shutdown();
	}
}
