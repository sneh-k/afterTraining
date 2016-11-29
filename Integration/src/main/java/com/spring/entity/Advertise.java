package com.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="ADVERTISE")
public class Advertise {
	
	@Id
	@GeneratedValue
	@Column(name="postId")
	private int postId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="title")
	private String title;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private User user;
	
	@Column(name="category")
	private String category;
	
	@Column(name="description")
	private String description;
	
	@Column(name="photoCount")
	private int photoCount;

	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(mappedBy="advertise", cascade={CascadeType.ALL})
	private Set<Photo> photos;
	
	public Advertise() {
	}

	public Advertise(String status, String title, String category, String description, int photoCount) {
		this.status = status;
		this.title = title;
		this.category = category;
		this.description = description;
		this.photoCount = photoCount;
	}
	
	public Advertise(String status, String title, User user, String category, String description, int photoCount, Set<Photo> photos) {
		this.status = status;
		this.title = title;
		this.user = user;
		this.category = category;
		this.description = description;
		this.photoCount = photoCount;
		this.photos = photos;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPhotoCount() {
		return photoCount;
	}

	public void setPhotoCount(int photoCount) {
		this.photoCount = photoCount;
	}

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "Advertise [postId=" + postId + ", status=" + status + ", title=" + title + ", user=" + user
				+ ", category=" + category + ", description=" + description + ", photoCount=" + photoCount + "]";
	}

}
