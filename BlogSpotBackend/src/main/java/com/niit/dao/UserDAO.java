package com.niit.dao;

import java.util.List;

import com.niit.model.UserDetail;

public interface UserDAO {

	public boolean registerUser(UserDetail userDetail);
	public boolean checkLogin(UserDetail userDetail);
	public UserDetail getUser(String loginName);
	public boolean updateOnlineStatus(String status,UserDetail userDetail);
	public boolean updateUser(UserDetail user);
	public boolean deleteuser(UserDetail user);
	public List<UserDetail> listUsers();
	
}
