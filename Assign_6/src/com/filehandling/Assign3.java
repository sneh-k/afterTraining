package com.filehandling;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
class Acc
{
	private int acno;
	private String name;
	private double bal;
	
	public Acc(int acno,String name, double bal)
	{
		this.acno=acno;
		this.name=name;
		this.bal=bal;
	}
	
	
}*/
public class Assign3 {

	public static void main(String[] args) throws IOException {

		File file = new File("abc1.txt");
		FileOutputStream fos = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeInt(101);
		dos.writeUTF("ABC");
		dos.writeDouble(12000.85);
		
		dos.writeInt(102);
		dos.writeUTF("DEF");
		dos.writeDouble(15000.25);

		dos.writeInt(103);
		dos.writeUTF("GHI");
		dos.writeDouble(11600.21);

		dos.flush();
		fos.flush();
		dos.close();
		fos.close();

		FileInputStream fis = new FileInputStream(file);
		DataInputStream dis = new DataInputStream(fis);

		while(dis.available()!=0){
		int id = dis.readInt();
		String name = dis.readUTF();
		double balance = dis.readDouble();
		System.out.println("acno : "+id+" "+"-Name : "+name+"-Bal : "+balance);
		}
		dis.close();
		fis.close();
	}

}
