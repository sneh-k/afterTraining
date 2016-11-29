package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Advertise;

public class AdvertiseDAOImpl implements AdvertiseDAO{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public Advertise create(Advertise advertise) {
		hibernateTemplate.save(advertise);
		return advertise;
	}
	
//	@Transactional
//	public User 

//	@Transactional
//	public List<String> categories()
//	{
//		List<Advertise> ads=hibernateTemplate.loadAll(Advertise.class);
//		List<String> list=new ArrayList<String>();
//		
//		for(Advertise a:ads)
//			list.add(a.getCategory());
//		return list;
//	}
//	
//	@Transactional
//	public List<String> actions()
//	{
//		List<Advertise> ads=hibernateTemplate.loadAll(Advertise.class);
//		List<String> list=new ArrayList<String>();
//		
//		for(Advertise a:ads)
//			list.add(a.getStatus());
//		return list;
//	}
}
