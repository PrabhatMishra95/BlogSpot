package com.niit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
@SequenceGenerator(name = "blogidseq", sequenceName="blog_id_seq", allocationSize = 1)
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blogidseq")
	@Column(name ="blogId")
	private int blogId;
	
	@Column(name ="blogName")
	private String blogName;
	
	@Column(name ="blogContent")
	private String blogContent;
	
	@Column(name ="createDate")
	private Date createDate;
	
	@Column(name ="loginname")
	private String loginname;
	
	@Column(name ="likes")
	private int likes;
	
	@Column(name ="dislikes")
	private int dislikes;
	
	@Column(name ="status")
	private String status;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
