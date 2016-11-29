package com.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Assign5 {

	public static void serialize() throws IOException
	{
		File file = new File("abc.txt");
		FileOutputStream fout = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(new Acc(101, "ABC", new Date(3,10,2016)));
		out.flush();
		out.close();
		System.out.println("Object Serialized..");
	}
	
	public static void deserialize() throws IOException, ClassNotFoundException
	{
		File file = new File("abc.txt");
		FileInputStream fin = new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(fin);
		Acc ac = (Acc)in.readObject();
		System.out.println(ac);
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		serialize();
		deserialize();

	}

}
