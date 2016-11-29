package com.hibernate.ChattingApp;


import java.util.HashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class HibernatePersistance implements Persistance
{
	
	Configuration config;
	SessionFactory sf;
	
	public HibernatePersistance() {
		config=new Configuration();
		config.configure("hibernate.cfg.xml");
		sf=config.buildSessionFactory();
	}

	public void createChatRoom(String name) {
		
		Session session=sf.openSession();
		Chatroom cr=new Chatroom(name);
		Transaction t=session.beginTransaction();
		session.persist(cr);
		t.commit();
		session.close();
	}

	public void addUser(String cname,String uname) {
		int id;
		Session session=sf.openSession();
		User u1=new User();
		u1.setUsername(uname);
		Transaction t=session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Chatroom.class);
		criteria.add(Restrictions.eq("name", cname));
		
		Chatroom cr = (Chatroom) criteria.uniqueResult();
		
//		Query query=session.createQuery("from Chatroom c where c.name=cname ");
//		List<Chatroom> list=query.list();
//		for(Chatroom c:list)
//		{	 id=c.getId();
//		cr=session.load(Chatroom.class, id);
//		cr=(Chatroom)list;
		cr.setUsers(new HashSet<User>());
		cr.getUsers().add(u1);
		
		session.save(cr);
		
		t.commit();
		session.close();
	}

	public void sendMsg() {
		// TODO Auto-generated method stub
		
	}

	public void login() {
		// TODO Auto-generated method stub
		
	}

	public void logout() {
		// TODO Auto-generated method stub
		
	}

	public void displayMsgs() {
		// TODO Auto-generated method stub
		
	}

	public void displayUsers() {
		// TODO Auto-generated method stub
		
	}

	public void deleteMsgs() {
		// TODO Auto-generated method stub
		
	}

}
