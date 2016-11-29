package com.exceptions;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Sample {
	public static void main(String[] args) throws Exception
	{
		int x=5;
		int y=0;

		try
		{
//			int z=x/y;
			
			try
			{
				FileInputStream fstream = new FileInputStream("abc.txt");
	            DataInputStream dis = new DataInputStream(fstream);
	            BufferedReader br = new BufferedReader(new InputStreamReader(dis));

	            String str = br.readLine();
	            
			}
			catch(FileNotFoundException e)
			{
				System.out.println("caught FileNotFound Excpetion");
			}
			finally
			{
				
				System.out.println("inner finally");
			}
			
			System.out.println("inside out try");
		}
/*		catch(ArithmeticException e)
		{
			System.out.println("caught Arithmetic exception");
		}
		catch(Exception e)
		{
			System.out.println("caught exception");
		}
*/		finally
		{
			System.out.println("in finally");
		}
	}
}
