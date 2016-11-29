package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dao.AdvertiseDAO;
import com.spring.entity.Advertise;

public class AdvertiseServiceImpl implements AdvertiseService {

	@Autowired
	private AdvertiseDAO advertiseDao;
	
	public Advertise create(Advertise advertise) {

		return advertiseDao.create(advertise);
	}
	
//	public List<String> categories()
//	{
//		return advertiseDao.categories();
//	}
//	
//	public List<String> actions()
//	{
//		return advertiseDao.actions();
//	}
}
