package com.exceptions;

class InsufficientBalanceException extends Exception
{
	private String msg;
	public InsufficientBalanceException()
	{
		this.msg="";
	}
	public InsufficientBalanceException(String msg)
	{
		this.msg=msg;
	}
	public String toString()
	{
		return "Balance insufficient.. "+this.msg;
	}
}

class Accno 
{
	private int bal;
	Accno()
	{
		this.bal=0;
	}
	Accno(int b)
	{
		this.bal=b;
	}
	public int getBaln()
	{
		return this.bal;
	}
	public void setBaln(int b)
	{
		this.bal=b;
	}
	public void withdraw(int b) throws InsufficientBalanceException
	{
		System.out.println("inside withdraw");
		if(b>this.bal)
			throw new InsufficientBalanceException(" Entered amount : "+b +" Balance : "+this.bal);			
		this.bal=this.bal-b;
	}
}
public class CustomExcp {

	public static void main(String[] args) {
		
		Accno a=new Accno(1000);
		try
		{
			System.out.println("inside try");
			a.withdraw(2000);
		}
		catch(InsufficientBalanceException e)
		{
			e.printStackTrace();
		}
	}

}
