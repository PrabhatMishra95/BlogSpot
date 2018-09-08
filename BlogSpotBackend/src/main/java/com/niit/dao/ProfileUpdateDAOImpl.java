package com.niit.dao;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.niit.model.Profile;

@Service
@Repository("profileDAO")
public class ProfileUpdateDAOImpl implements ProfileUpdateDAO {

	@Autowired SessionFactory sessionfactory;
	
	@Transactional
	public void saveProfilePic(Profile profilePicture)
	{
		sessionfactory.getCurrentSession().save(profilePicture);		
	}

	@Transactional
	public Profile getProfilePicture(String loginname) {
		Session session=sessionfactory.openSession();
		Profile profilePicture=(Profile)session.get(Profile.class, loginname);
		return profilePicture;
	}

}
