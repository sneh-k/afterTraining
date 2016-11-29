package com.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="PHOTO")
public class Photo {
	
	@Id
	@GeneratedValue
	@Column(name="photoId")
	private int photoId;
	
	@Column(name="content")
	private String content;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="postId")
	private Advertise advertise;

	public Photo() {
	}

	public Photo(String content) {
		this.content = content;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Photo [photoId=" + photoId + ", content=" + content + "]";
	}

}
