package com.niit.RestControllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.dao.ProfileUpdateDAO;
import com.niit.model.Profile;
import com.niit.model.UserDetail;



@RestController
public class ProfileController {
	
	
	@Autowired
	ProfileUpdateDAO profileUpdateDAO;
	
	@PostMapping("/doUpload")
	public ResponseEntity<?> uploadProfilePicture(@RequestParam(value="file") CommonsMultipartFile fileUpload, HttpSession session)
	{
		UserDetail userDetail=(UserDetail)session.getAttribute("userDetail");
		if(userDetail==null)
		{
			return new ResponseEntity<String>("Unauthorised User",HttpStatus.NOT_FOUND);
		}
		else
		{
			Profile profilePicture=new Profile();
			profilePicture.setLoginname(userDetail.getLoginname());
			profilePicture.setImage(fileUpload.getBytes());
			profileUpdateDAO.saveProfilePic(profilePicture);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@RequestMapping("/getImage/{loginname}")
	public @ResponseBody byte[] getProfilePicture(@PathVariable("loginname") String loginname,HttpSession session)
	{
		UserDetail userDetail=(UserDetail)session.getAttribute("userDetail");
		
		if(userDetail==null)
		{
			return null;
		}
		else
		{
		Profile profilePicture = profileUpdateDAO.getProfilePicture(loginname);
		
		if(profilePicture!= null)
		{
			return profilePicture.getImage();
		}
		else
		{
			return null;
		}
	}
	}

}

