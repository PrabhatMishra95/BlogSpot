package com.niit.TestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;

import com.niit.model.UserDetail;

public class userTest {
	private static UserDAO userdao;
	private UserDetail user;
	
	@BeforeClass
	public void intialise() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
	userdao =	(UserDAO) context.getBean("UserDAO");
	}
	
	@Ignore
	@Test
	public void deleteUserTest() {
		user = userdao.getUser("Sam");
assertEquals("Succefully deleted the user Test Case",true, userdao.deleteuser(user));

	}
	@Ignore
	@Test
	public void getUserTest() {
		
		
		assertEquals("Successfully fetched  the username   from the Table", 1,userdao.listUsers().size());
		System.out.println("---------------Fetched from the List Successfully------------");

	}
	@Test
	public void insertUserTest() {
		
		UserDetail user = new UserDetail();
		user.setUserName("Prabhat");
		user.setEmailid("Prabhat@gmail.com");
		user.setPassword("prabhat@123");
		user.setRole("USER");
		assertEquals("Successfully added User into the Table", true , userdao.registerUser(user));
		System.out.println("---------------Successfully Inserted into User----------------");
	}
	@Test
	public void updateUserTest() {
		UserDetail user = new UserDetail();
		user = userdao.getUser("Sam");
		user.setUserName("Sam Jebastin");
		assertEquals("Successfully Updated User into the table",true,userdao.updateUser(user));
		System.out.println("---------Successfully Updated User------------");
		
	}
	
	private static UserDAO userDAO;
	@Test
	void registerUser() {
		UserDetail userDetail = new UserDetail();
		userDetail.setLoginName("Sam");
		userDetail.setPassword("sam@123");
		userDetail.setRole("ADMIN");
		userDetail.setUserName("Samuel Jebastin");
		userDetail.setEmailid("samjebastin77@gmail.com");
		userDetail.setAddress("Bhiwandi");
		userDetail.setMobileNo("9766376624");
		userDetail.setIsOnline("N");
		assertTrue("Problem in Registering User", userDAO.registerUser(userDetail));
		System.out.println("-----------------------Sucessfully UserDetails is Registered------------------");
	}

	@Ignore
	@Test
	public void updateIsOnLineTest() {
		UserDetail userDetail = userDAO.getUser("Sam");
		assertTrue("Problem in Updating Status", userDAO.updateOnlineStatus("O", userDetail));
		System.out.println("----------------------Successfully Updated User is Online----------------------");

	}

	@Ignore
	@Test
	public void checkUserTest() {
		UserDetail userDetail = new UserDetail();
		userDetail.setLoginName("Sam");
		userDetail.setPassword("sam@123");
		assertTrue("Problem in Checking User Test Case", userDAO.checkLogin(userDetail));
		System.out.println("Checked User Successfully");
	}

}
