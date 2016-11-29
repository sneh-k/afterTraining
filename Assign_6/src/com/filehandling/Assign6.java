package com.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;

class Acc1 implements Serializable
{

	private int acno;
	private String name;
	private double sal;
	long start=0;
	long next=0;
	public Acc1()
	{
		
	}
/*	public Acc1(int acno,String name, double sal)
	{
		this.acno=acno;
		this.name=name;
		this.sal=sal;
	}	
*/	public String toString()
	{
		return "Acno : "+this.acno+"\nName : "+this.name+"\nSal : "+this.sal;
	}
	
	public void createAcc(int acno,String name, double sal ) throws IOException
	{
		
		File file = new File("abc.txt");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		this.start=raf.getFilePointer();
		raf.seek(this.next);
		raf.writeInt(acno);
		raf.writeUTF(name);
		raf.writeDouble(sal);
		this.next = raf.getFilePointer(); 
		
	}
	public void readAcc() throws IOException
	{
		File file = new File("abc.txt");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.seek(this.start);
		int id = raf.readInt();
		String name = raf.readUTF();
		double bal = raf.readDouble();
		System.out.println("acno : "+id+" "+"-Name : "+name+"-Bal : "+bal);
		raf.close();

	}
	
	
	public static void main(String[] args) {
		
		
	}

}


public class Assign6 {

/*	public static void serialize() throws IOException
	{
		File file = new File("abc.txt");
		FileOutputStream fout = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fout);
//		out.writeObject();
		out.flush();
		out.close();
		System.out.println("Object Serialized..");
	}
	
	public static void deserialize() throws IOException, ClassNotFoundException
	{
		File file = new File("abc.txt");
		FileInputStream fin = new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(fin);
		Acc1 ac = (Acc1)in.readObject();
		System.out.println(ac);
	}
*/	
	public static void main(String[] args) throws IOException {
		
		Acc1 a[]= new Acc1[3];
		a[0]=new Acc1();
		a[0].createAcc(101, "ABC", 15000.35);
		a[1]=new Acc1();
		a[1].createAcc(101, "ABC", 15000.35);
		a[2]=new Acc1();
		a[2].createAcc(101, "ABC", 15000.35);

		a[0].readAcc();

	}

}
