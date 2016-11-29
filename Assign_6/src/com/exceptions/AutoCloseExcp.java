package com.exceptions;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

class AutoClose extends Exception implements AutoCloseable
{
	private String msg;
	public AutoClose()
	{
		this.msg="";
	}
	public AutoClose(String msg)
	{
		this.msg=msg;
	}
	public String toString()
	{
		return "FileCLosed.. "+this.msg;
	}
	@Override
	public void close(){
		// TODO Auto-generated method stub
		System.out.println("inside close");
	}

}

public class AutoCloseExcp {

	public static void main(String[] args) throws AutoClose {
		
		try(FileInputStream fstream = new FileInputStream("C:\\Users\\kamat_sn\\workspace\\Assign_6\\src\\com\\exceptions\\abc");)
		{
            DataInputStream dis = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            System.out.println("inside try");
            
            throw new AutoClose("Closed...");
            
		}
		catch(AutoClose e)
		{			
			System.out.println("inner autoclose");
			e.close();
			e.printStackTrace();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("inner filenotfound");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("inner ioexception");
		} 
		
		System.out.println("at end");

	}

}
