package com.thread;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;

import javax.swing.RepaintManager;

import java.awt.event.WindowAdapter;

public class BallGame extends Frame {

		static int y1 = 400;
		static int y2 = 400;
		static int y3 = 400;
		
		public BallGame() {
			super("Ball game");
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
		


	public static void main(String[] args) {
		Frame mf = new BallGame();
		mf.setSize(500, 500);
		mf.setVisible(true);
		
		Thread t1=new Thread(new Runnable() 
		{
			@Override
			synchronized public void run()
			{
				for(;;)
				{
					while(y1>100) {
						y1=y1-20;
						mf.repaint();
						try
						{
							Thread.sleep(200);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}

					while(y1<400){
						y1=y1+20;
						mf.repaint();
						try
						{
							Thread.sleep(200);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
						
				}
			}
		}
		 
		);
		
		Thread t2=new Thread(new Runnable() 
		{
			@Override
			synchronized public void run()
			{
				for(;;)
				{
					while(y2>100){
						y2=y2-20;
						mf.repaint();
						try
						{
							Thread.sleep(300);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}

					while(y2<400){
						y2=y2+20;
						mf.repaint();
						try
						{
							Thread.sleep(300);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
						
				}
					
			}
		} 
		);
		
		Thread t3=new Thread(new Runnable() 
		{
			@Override
			synchronized public void run()
			{
				for(;;)
				{
					while(y3>100){
						y3=y3-20;
						mf.repaint();
						try
						{
							Thread.sleep(400);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}

					while(y3<400){
						y3=y3+20;
						mf.repaint();
						try
						{
							Thread.sleep(400);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
						
				}
					
			}
		} 
		);
		t1.start();
		t2.start();
		t3.start();
		
	}

}

