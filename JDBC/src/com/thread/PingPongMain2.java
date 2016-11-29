package com.thread;

public class PingPongMain2 extends Thread{
	
	public PingPongMain2(String name) {
		this.setName(name);
		start();
	}
	
	@Override
	public void run() {
		
		Thread currentThread=Thread.currentThread();
		
		if(currentThread.getName().equals("PING"))
		{
			for(int i=0;i<10;i++){
				System.out.println("PING");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
		else if(currentThread.getName().equals("PONG"))
		{
			for(int i=0;i<10;i++){
				System.out.println("\tPONG");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
		else if(currentThread.getName().equals("TONG"))
		{
			for(int i=0;i<10;i++){
				System.out.println("\t\tTONG");
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
	}

	public static void main(String[] args) {
		PingPongMain2 p1=new PingPongMain2("PING");
		PingPongMain2 p2=new PingPongMain2("PONG");
		PingPongMain2 p3=new PingPongMain2("TONG");
	}
}
