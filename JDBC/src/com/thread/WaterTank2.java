package com.thread;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class WaterTank2 extends Frame implements Runnable {

	int y1 = 400, y2 = 400, y3 = 400;
	static int y=210,per=0;
	public WaterTank2() {
		super("Ball game");
		Thread t1=new Thread(this);
		Thread t2=new Thread(this);
		Thread t3=new Thread(this);
		t1.setName("INLET");
		t2.setName("OUTLET");
		t3.setName("CONTROLLER");
		t3.setDaemon(true);
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
	
	@Override
	public void run()
	{
		Thread currentThread=Thread.currentThread();
		
		if(currentThread.getName().equals("INLET"))
		{
			for(;;){
				if(y<240)
				{
					y=y+3;
					per=y/3;
					repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else
				{	
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		else if(currentThread.getName().equals("OUTLET"))
		{
			for(;;){
				if(y>0)
				{
					y=y-3;
					per=y/3;
					repaint();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else
				{	
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		else if(currentThread.getName().equals("CONTROLLER"))
		{
			for(;;){
			//	while(y>-240)
				{
				//	y=y-10;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public void paint(Graphics g) {
		g.drawRect(150, 100, 200, 300);
		g.setColor(Color.RED);
//		g.fillRect(150, 200, 200, 200);
		g.fillRect(150, 400, 200, -y);
		g.drawString(per +"%", 380, 200);
	}

	public static void main(String[] args) {
		CalcPrint val=new CalcPrint();
		Frame mf = new WaterTank2();
		mf.setSize(500, 500);
		mf.setVisible(true);
	}
}
