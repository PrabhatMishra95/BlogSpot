package com.niit.dao;

import java.util.List;

import com.niit.model.Forum;

public interface ForumDAO {
	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean approveForum(Forum forum);
	public boolean rejectForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> listForum();

}
