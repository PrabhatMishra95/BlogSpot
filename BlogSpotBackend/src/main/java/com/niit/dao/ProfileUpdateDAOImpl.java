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
	public void saveProfilePic(Profile profilePicture) {
		System.out.println("Profile Loginname:" +profilePicture.getLoginname());
	Session session = sessionfactory.openSession();
	session.save(profilePicture);
	/*session.flush();*/
	session.close();
		
	}

	@Transactional
	public Profile getProfilePicture(String loginname) {
		Session session = sessionfactory.openSession();
		Profile profile=session.get(Profile.class, loginname);
		session.close();
		return profile;
	}

}
