package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PingPongMain4{
	
	public static void main(String[] args) 
	{
		Callable<Void> c1=new Callable<Void>() {

			@Override
			public Void call() throws Exception {
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
				return null;
			}
		};

		Callable<Void> c2=new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				for(int i=0;i<10;i++)
				{
					System.out.println("\tPONG");
					try 
					{
						Thread.sleep(300);
					} 
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				return null;
			}
		};
		
		
		
		Callable<Void> c3=new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				for(int i=0;i<10;i++)
				{
					System.out.println("\t\tTONG");
					try 
					{
						Thread.sleep(200);
					} 
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				return null;
			}
		};
		

		ExecutorService e=Executors.newFixedThreadPool(3);
		Future<Void> f1=e.submit(c1);
		Future<Void> f2=e.submit(c2);
		Future<Void> f3=e.submit(c3);
		e.shutdown();
		
	}
}
