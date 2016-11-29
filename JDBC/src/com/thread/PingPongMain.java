package com.thread;

public class PingPongMain implements Runnable{
	
	public PingPongMain() {
		
		Thread t1,t2,t3;
		t1=new Thread(this);
		t2=new Thread(this);
		t3=new Thread(this);
		t1.setName("PING");
		t2.setName("PONG");
		t3.setName("TONG");
		t3.setDaemon(true);
		t1.start();
		t2.start();
		t3.start();
	}
	
	@Override
	public void run() {
		
		Thread currentThread=Thread.currentThread();
		
		if(currentThread.getName().equals("PING"))
		{
			for(int i=0;i<10;i++){
				System.out.println("PING");
			try {
				Thread.sleep(300);
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
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
		else if(currentThread.getName().equals("TONG"))
		{
			for(;;){
				System.out.println("\t\tTONG");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
	}

	public static void main(String[] args) {
		new PingPongMain();
	}
}
