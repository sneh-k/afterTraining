package com.spring.Restful;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restful")
public class Controller 
{
	
	@RequestMapping(value="/login", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void login(@RequestBody User user)
	{
		user.setUserId(101);
		if(user.getUsername().equals(user.getPassword()))
			System.out.println("LOGIN successful");
		else
			System.out.println("LOGIN unsuccessful");
		System.out.println(user);
	}
	
	
	@RequestMapping(headers={"auth_token"}, value="/logout", method=RequestMethod.DELETE)	
	public void logout(@RequestParam(value="auth_token" , defaultValue="true" ) String auth_token) 
	{
		if("true".equals(auth_token))
			System.out.println("LOGGED out..");
		else
			System.out.println("LOGout unsuccessful..");
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public List<String> categories()
	{
		List<String> categories=new ArrayList<String>();
		categories.add("Category 1");
		categories.add("Category 2");
		categories.add("Category 3");
		categories.add("Category 4");
		categories.add("Category 5");
		for(String s:categories)
			System.out.println(s);
		
		return categories;
	}
	
	
	@RequestMapping(headers={"auth_token"},value="/actions", method=RequestMethod.GET)
	public List<String> actions(@RequestHeader String auth_token)
	{
		List<String> actions=new ArrayList<String>();
		actions.add("Action1");
		actions.add("Action2");
		actions.add("Action3");
		actions.add("Action4");

		for(String s:actions)
			System.out.println(s);
		if("true".equals(auth_token))
			return actions;
		else
			return null;
	}
	
	
	@RequestMapping(value="/postAd", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Ad postAd(@RequestBody Ad ad)
	{
		List<String> list=new ArrayList<String>();
		for(int i=0;i<ad.getPhotoCount();i++)
			list.add("photo"+(i+1));
			ad.setPhoto(list);
		return ad;
	}
	
	
	@RequestMapping(value="/postAd2", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Ad postAd2(@RequestBody Ad ad)
	{
		List<String> list=new ArrayList<String>();
		for(int i=0;i<ad.getPhotoCount();i++)
			list.add("photo"+(i+1));
			ad.setPhoto(list);
			ad.setPostId(201);
			ad.setStatus("open");
		return ad;
	}
	
	
	@RequestMapping(headers={"auth_token"},value="/posts", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Ad> posts(@RequestHeader String auth_token)
	{
		List<Ad> ads=new ArrayList<Ad>();
		ads.add(new Ad(101,"open","Laptop","ABC","Hardware",2));
		ads.add(new Ad(102,"closed","AC","DEF","Hardware",3));
		ads.add(new Ad(103,"open","Antivirus","GHI","Software",1));
		
		return ads;
	}
	
	
	@RequestMapping(headers={"auth_token"},value="/post", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Ad post(@RequestParam(value="postId" , defaultValue= "102") int postId,@RequestHeader String auth_token)
	{
		List<Ad> ads=new ArrayList<Ad>();
		ads.add(new Ad(101,"open","Laptop","ABC","Hardware",2));
		ads.add(new Ad(102,"closed","AC","DEF","Hardware",3));
		ads.add(new Ad(103,"open","Antivirus","GHI","Software",1));
		
		for(Ad a1:ads)
			if(a1.getPostId()==postId)
				return a1;
		
		return null;
	}
	
	
	@RequestMapping(headers={"auth_token"},value="/post2", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Ad post2(@RequestParam(value="postId" , defaultValue= "102") int postId,@RequestHeader String auth_token)
	{
		List<Ad> ads=new ArrayList<Ad>();
		ads.add(new Ad(101,"open","Laptop","ABC","Hardware",2));
		ads.add(new Ad(102,"closed","AC","DEF","Hardware",3));
		ads.add(new Ad(103,"open","Antivirus","GHI","Software",1));
		
		for(Ad a1:ads)
			if(a1.getPostId()==postId)
				return a1;
		
		return null;
	}
	
	@RequestMapping(headers={"auth_token"},value="/photo", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String photo(@RequestParam(value="photo" , defaultValue= "photo2") String photo1,@RequestHeader String auth_token)
	{
		Map<Integer,String> map = new HashMap<Integer, String>();
		Ad ads=new Ad(101,"open","Laptop","ABC","Hardware",2);
		String pic=null;
			for(int i=0;i<ads.getPhotoCount(); i++)
			{
				map.put(i+1, "photo"+(i+1));
			}
		ads.setHmap(map);
			for (Map.Entry<Integer, String> entry : ads.getHmap().entrySet() )
			{
				if(photo1.equals(entry.getValue()))
				{
					pic=entry.getValue();
				}
			}
		return pic;
	}
	
	
	@RequestMapping(headers={"auth_token"},value="/photo2", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String photo2(@RequestParam(value="photo" , defaultValue= "photo2") String photo1,@RequestHeader String auth_token)
	{
		Map<Integer,String> map = new HashMap<Integer, String>();
		Ad ads=new Ad(101,"open","Laptop","ABC","Hardware",2);
		String pic=null;
			for(int i=0;i<ads.getPhotoCount(); i++)
			{
				map.put(i+1, "photo"+(i+1));
			}
		ads.setHmap(map);
			for (Map.Entry<Integer, String> entry : ads.getHmap().entrySet() )
			{
				if(photo1.equals(entry.getValue()))
				{
					pic=entry.getValue();
				}
			}
		return pic;
	}
	
	@RequestMapping(headers={"auth_token"},value="/search", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Ad> search(@RequestHeader String auth_token)
	{
		List<Ad> ads=new ArrayList<Ad>();
		ads.add(new Ad(101,"open","Laptop","ABC","Hardware",2));
		ads.add(new Ad(102,"closed","AC","DEF","Hardware",3));
		ads.add(new Ad(103,"open","Antivirus","GHI","Software",1));
		List list=new ArrayList<>();
		String criteria=auth_token;
		switch(criteria)
		{
		case "postId" : for(Ad a:ads)
							list.add((a.getPostId()));
						break;
		case "status" : for(Ad a:ads)
							list.add((a.getStatus()));
						break;
		case "title" : for(Ad a:ads)
							list.add((a.getTitle()));
						break;
		case "name" : for(Ad a:ads)
							list.add((a.getName()));
						break;
		case "category" : for(Ad a:ads)
							list.add((a.getCategory()));
						break;
		case "photoCount" : for(Ad a:ads)
							list.add((a.getPhotoCount()));
						break;
		
		}
		
		return list;
	}
	
	@RequestMapping(headers={"auth_token"},value="/search2/{criteria}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Ad> search2(@PathVariable(value="criteria") String criteria,@RequestHeader String auth_token)
	{
		List<Ad> ads=new ArrayList<Ad>();
		ads.add(new Ad(101,"open","Laptop","ABC","Hardware",2));
		ads.add(new Ad(102,"closed","AC","DEF","Hardware",3));
		ads.add(new Ad(103,"open","Antivirus","GHI","Software",1));
		List list=new ArrayList<>();
		switch(criteria)
		{
		case "postId" : for(Ad a:ads)
							list.add((a.getPostId()));
						break;
		case "status" : for(Ad a:ads)
							list.add((a.getStatus()));
						break;
		case "title" : for(Ad a:ads)
							list.add((a.getTitle()));
						break;
		case "name" : for(Ad a:ads)
							list.add((a.getName()));
						break;
		case "category" : for(Ad a:ads)
							list.add((a.getCategory()));
						break;
		case "photoCount" : for(Ad a:ads)
							list.add((a.getPhotoCount()));
						break;
		}
		return list;
	}
	
	
	@RequestMapping(headers={"auth_token"},value="/dateconditions", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String dateconditions(@RequestHeader String auth_token)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String str;
		
		if("true".equals(auth_token))
			return " Date : "+dateFormat.format(date);
		else
			return null;
	}
	
	
	@RequestMapping(headers={"auth_token"},value="/viewAd", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Ad> viewAd(@RequestHeader String auth_token)
	{
		List<Ad> ads=new ArrayList<Ad>();
		List<String> list=new ArrayList<String>();
		
		Ad a1=new Ad(101,"open","Laptop","ABC","Hardware",2);
		ads.add(a1);
		for(int i=0;i<a1.getPhotoCount();i++)
			list.add("photo"+(i+1));
		a1.setPhoto(list);
		
		List<String> list2=new ArrayList<String>();
		
		Ad a2=new Ad(102,"closed","AC","DEF","Hardware",3);
		ads.add(a2);
		for(int i=0;i<a2.getPhotoCount();i++)
			list2.add("photo"+(i+1));
		a2.setPhoto(list2);
		
		List<String> list3=new ArrayList<String>();
		
		Ad a3=new Ad(103,"open","Antivirus","GHI","Software",1);
		
		ads.add(a3);
		for(int i=0;i<a3.getPhotoCount();i++)
			list3.add("photo"+(i+1));
		a3.setPhoto(list3);
		
		return ads;
	}
	
	
	@RequestMapping(headers={"auth_token"},value="/message/{criteria}", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public String message(@PathVariable(value="criteria") String criteria,@RequestHeader String auth_token)
	{
		Ad ads=new Ad(101,"open","Laptop","ABC","Hardware",2);
		return " Message : "+criteria+", postId : "+ads.getPostId();
	}
	
	@RequestMapping(headers={"auth_token"},value="/register", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public User register(@RequestBody User user,@RequestHeader String auth_token)
	{
		User u1=new User();
		u1=user;
		
		return u1;
	}
	
	
	@RequestMapping(headers={"auth_token"},value="/user", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public User user(@RequestParam(value="userId" , defaultValue= "102") int userId,@RequestHeader String auth_token)
	{
		List<User> ads=new ArrayList<User>();
		ads.add(new User(101,"ABC","ABC123"));
		ads.add(new User(102,"DEF","DEF123"));
		ads.add(new User(103,"GHI","GHI123"));
		
		for(User a1:ads)
			if(a1.getUserId()==userId)
				return a1;
		
		return null;
	}
	
}
