package com.mock.hibernate.HibernateSampl;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatDemo {
	
	
	public static void fireSQL(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();
		SQLQuery sqlQuery = session.createSQLQuery("INSERT INTO PRODUCT_MASTER(P_ID,NAME,COST) VALUES(524,'ACB',9765)");
//		sqlQuery.setParameter("pid", 110);
//		sqlQuery.setParameter("pname", "Fride");
//		sqlQuery.setParameter("pprice", 21000);	
		sqlQuery.executeUpdate();
//		session.save(sqlQuery);
//		session.flush();
		session.close();
			}

	public static void main(String[] args) {
		Configuration configuration=new Configuration();
		configuration.configure(new File("src/hibernate.cfg.xml"));

		SessionFactory sessionFactory=configuration.buildSessionFactory();
		
		//CREATE
		Session ses1=sessionFactory.openSession();
		Product p1=new Product("Laptop",45000);
		ses1.save(p1);
		Product p2=new Product("Drier",15000);
		ses1.save(p2);		
		long id=p2.getId();
		ses1.flush();
		ses1.close();
		
		//RETRIEVE
				Session ses2=sessionFactory.openSession();
				List<Product> pList=ses2.createQuery("from Product").list();
				for (Product p:pList)
					System.out.println(p);
				ses2.close();
		
		//UPDATE
		Session ses3=sessionFactory.openSession();
		Product p3=ses3.get(Product.class,id);	
		p3.setPrice(50000);
		ses3.update(p3);
		ses3.flush();
		ses3.close();
		
		//DELETE
		Session ses4=sessionFactory.openSession();
		Product p4 = ses4.get(Product.class, id);
		ses4.delete(p4);
		ses4.flush();
//		Query query2=ses4.createQuery("delete from Product");
//		query2.executeUpdate();
		ses4.close();
		
		
		//CREATE
		Session ses6=sessionFactory.openSession();
		Product p5=new Product("AC",30000);
		ses6.save(p5);		
		ses6.flush();
		ses6.close();
		
		fireSQL(sessionFactory);
		
		//RETRIEVE
		Session ses5=sessionFactory.openSession();
		List<Product> pList2=ses5.createQuery("from Product").list();
		for (Product p:pList2)
			System.out.println(p);
		ses5.close();

		sessionFactory.close();
		
	}

}
