package com.thread;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.RepaintManager;
import java.awt.event.WindowAdapter;

public class BallGame3 extends Frame {
		ReentrantLock lock=new ReentrantLock();
		Condition notTop  = lock.newCondition();
		Condition notBotom = lock.newCondition();
		
		static int y1 = 400;
		static int y2 = 400;
		static int y3 = 400;
		
		public BallGame3() {
			super("Ball game");
			
			Thread t1=new Thread(new Runnable() 
			{
				@Override
				public void run()
				{
					for(;;)
					{
						while(y1>100) {
							y1=y1-20;
							repaint();
							try
							{
								Thread.sleep(200);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						try {
							check1();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						while(y1<400){
							y1=y1+20;
							repaint();
							try
							{
								Thread.sleep(200);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						try {
							check2();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							
					}
				}
			}
			 
			);
			
			Thread t2=new Thread(new Runnable() 
			{
				@Override
				public void run()
				{
					for(;;)
					{
						while(y2>100){
							y2=y2-20;
							repaint();
							try
							{
								Thread.sleep(300);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						try {
							check1();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						while(y2<400){
							y2=y2+20;
							repaint();
							try
							{
								Thread.sleep(300);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						try {
							check2();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							
					}
						
				}
			} 
			);
			
			Thread t3=new Thread(new Runnable() 
			{
				@Override
				public void run()
				{
					for(;;)
					{
						while(y3>100){
							y3=y3-20;
							repaint();
							try
							{
								Thread.sleep(400);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						try {
							check1();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						while(y3<400){
							y3=y3+20;
							repaint();
							try
							{
								Thread.sleep(400);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						try {
							check2();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							
					}
						
				}
			} 
			);
			t1.setName("RED");
			t2.setName("GREEN");
			t3.setName("BLUE");
			t1.start();
			t2.start();
			t3.start();
			
			
			
			setBackground(Color.CYAN);
			setSize(500, 500);
			setVisible(true);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		}
		
		public void paint(Graphics g) {
			g.setColor(Color.RED);
			g.fillOval(100, y1, 50, 50);
			g.setColor(Color.GREEN);
			g.fillOval(200, y2, 50, 50);
			g.setColor(Color.BLUE);
			g.fillOval(300, y3, 50, 50);
		}
		
		public void check1() throws InterruptedException
		{
			lock.lock();
			Thread currentThread= Thread.currentThread();
			if(currentThread.getName().equals("RED"))
			{			
				try
				{
					if(y1==100)
						notTop.await();
				}
				finally
				{
					lock.unlock();
				}
				
			}
			else if(currentThread.getName().equals("GREEN"))
			{

				try
				{
					if(y2==100)
						notTop.await();
				}
				finally
				{
					lock.unlock();
				}
			}
			else if(currentThread.getName().equals("BLUE"))
			{
				{
				try
				{
					if(y3==100)
						notTop.signalAll();
				}
				finally
				{
					lock.unlock();
				}
				}
			}
		}


		public void check2() throws InterruptedException
		{
			lock.lock();
			Thread currentThread= Thread.currentThread();
			if(currentThread.getName().equals("RED"))
			{			
				try
				{
					if(y1==400)
						notBotom.await();
				}
				finally
				{
					lock.unlock();
				}
				
			}
			else if(currentThread.getName().equals("GREEN"))
			{

				try
				{
					if(y2==400)
						notBotom.await();
				}
				finally
				{
					lock.unlock();
				}
			}
			else if(currentThread.getName().equals("BLUE"))
			{
				{
				try
				{
					if(y3==400)
						notBotom.signalAll();
				}
				finally
				{
					lock.unlock();
				}
				}
			}
		}
		
	public static void main(String[] args) {
		Frame mf = new BallGame3();
		mf.setSize(500, 500);
		mf.setVisible(true);
		
		
	}

}

