package com.spring.Restful;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ad {

	private int postId;
	private String status;
	private String title;
	private String name;
	private String category;
	private int photoCount;
	private List<String> photo;
	private Map<Integer, String> hmap;
	
	
	
	public Map<Integer, String> getHmap() {
		return hmap;
	}

	public void setHmap(Map<Integer, String> hmap) {
		this.hmap = hmap;
	}

	public Ad() {
		super();
	}

	public Ad(String title, String name, String category, int photoCount) {
		this.title = title;
		this.name = name;
		this.category = category;
		this.photoCount = photoCount;
	}
	
	public Ad(int postId, String status, String title, String name, String category, int photoCount) {
		this.postId = postId;
		this.status = status;
		this.title = title;
		this.name = name;
		this.category = category;
		this.photoCount = photoCount;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPhotoCount() {
		return photoCount;
	}
	public void setPhotoCount(int photoCount) {
		this.photoCount = photoCount;
	}
	public List<String> getPhoto() {
		return photo;
	}
	public void setPhoto(List<String> photo) {
		this.photo = photo;
	}

//	@Override
//	public String toString() {
//		return "Ad [postId=" + postId + ", status=" + status + ", title=" + title + ", name=" + name + ", category="
//				+ category + ", photoCount=" + photoCount + ", hmap=" + hmap + "]";
//	}
	
	

//	@Override
//	public String toString() {
//		return "Ad [postId=" + postId + ", status=" + status + ", title=" + title + ", name=" + name + ", category="
//				+ category + ", photoCount=" + photoCount + "]";
//	}

//	@Override
//	public String toString() {
//		return "Ad [postId=" + postId + ", status=" + status + ", title=" + title + ", name=" + name + ", category="
//				+ category + ", photoCount=" + photoCount + ", photo=" + photo + "]";
//	}
	
	@Override
	public String toString() {
		return "Ad [title=" + title + ", name=" + name + ", category=" + category + ", photoCount=" + photoCount
				+ ", photo=" + photo + "]";
	}
	
}
