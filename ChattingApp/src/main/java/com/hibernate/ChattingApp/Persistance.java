package com.hibernate.ChattingApp;

public interface Persistance {
	
	void createChatRoom(String name);
	void addUser(String cname,String uname);
	void sendMsg();
	void login();
	void logout();
	void displayMsgs();
	void displayUsers();
	void deleteMsgs();
	
}
