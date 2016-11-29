package com.hibernate.ChattingApp;

public class Main {

	public static void main(String[] args)
	{
		PersistanceFactory factory= PersistanceFactory.getInstance();
		Persistance p= factory.getPersistance();
		p.createChatRoom("ABC");
		p.addUser("ABC", "User1");
	}
}
