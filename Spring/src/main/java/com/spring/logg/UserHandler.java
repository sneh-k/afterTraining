package com.spring.logg;

public class UserHandler 
{
	public static boolean flag=false;

	public void login(String username, String password)
	{
		 if(username.equals(password))
		 {
			 flag=true;
			System.out.println("LOGIN SUCCESSFUL..");
		 }
		else
			System.out.println("LOGIN UNSUCCESSFUL");
	}
	
	public void logout()
	{
		if(flag==true)
			System.out.println("Logout successful..");
		else
			System.out.println("No user Logged in..");
	}
	
	public void register(String username, String password)
	{
		System.out.println("Registered..");
	}
}
