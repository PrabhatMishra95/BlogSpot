package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDAO {

	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> listBlog();
	public boolean incrementLike(Blog blog);
}
