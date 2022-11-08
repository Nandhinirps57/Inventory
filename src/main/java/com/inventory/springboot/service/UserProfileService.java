package com.inventory.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.springboot.model.UserProfile;
import com.inventory.springboot.repository.UserProfileRepository;


@Service
public class UserProfileService {
      
	@Autowired
	UserProfileRepository upr;
	public UserProfile saveUserProfile(UserProfile userprofile) {
		
		return upr.save(userprofile);
	}
	public Object getProfiles(String search) {
		boolean isNumber=true;
		isNumber=search.matches("-?\\d+?");
		if(isNumber) {
			String s=search;
			long num=Long.parseLong(s);
			return upr.findByphoneNo(num);
		}
		else {
			System.out.println("Hitted");
		return upr.findByuserName(search);}
	}
	
	
	public List<UserProfile> getProfiles() {
		
		return upr.findAll();
	}
	public List<Object > getProfilesByBranch(String branch) {
		
		return upr.findAlluserprofileByBranch(branch);
	}
	public UserProfile getProfile(int id){
		
		return upr.findAlluserprofileByid(id);
	}
	public UserProfile updateUserProfile(UserProfile userprofile) {
		 UserProfile up= upr.findById(userprofile.getId()).orElseThrow();
		 up.setAboutMe(userprofile.getAboutMe());
		 up.setAddress(userprofile.getAddress());
		 up.setCity(userprofile.getCity());
		 up.setEmail(userprofile.getEmail());
		 up.setFirstName(userprofile.getFirstName());
		 up.setLastName(userprofile.getLastName());
		 up.setPhoneNo(userprofile.getPhoneNo());
		 up.setPostalCode(userprofile.getPostalCode());
		 up.setUserName(userprofile.getUserName());
	
		return upr.save(up);
	}

}
