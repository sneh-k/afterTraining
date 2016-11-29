package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Advertise;
import com.spring.service.AdvertiseService;

@RestController
public class AdverisementController {

	@Autowired
	private AdvertiseService advertiseService;
	
	public AdvertiseService getAdvertiseService() {
		return advertiseService;
	}

	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
	}

	@RequestMapping(value="/advertise", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Advertise createAdvertise(@RequestBody Advertise advertise) 
	{
		return advertiseService.create(advertise);
	}
	
	
//	@RequestMapping(value="/categories", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<String> getCategories() 
//	{
//		return advertiseService.categories();
//	}
//	
//	@RequestMapping(value="/actions", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<String> getActions() 
//	{
//		return advertiseService.actions();
//	}

}
