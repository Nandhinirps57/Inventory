package com.inventory.springboot.controller;

import java.io.IOException;
//import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.inventory.springboot.model.UserProfile;

import com.inventory.springboot.service.UserProfileService;

@Component()
@CrossOrigin("http://localhost:8081")
@RestController
public class UserProfileController {
     
	@Autowired
	UserProfileService ups;
	@PutMapping("/profileUpdate")
	public UserProfile updateUser(@RequestBody UserProfile userprofile) {
		System.out.println("Calling User to save...!");
		return ups.updateUserProfile(userprofile);
	}

//	@PostMapping("/addUserProfile/{file}")
//	public UserProfile addUser(@RequestBody UserProfile userprofile,@PathVariable("file") MultipartFile file) throws IOException {
//		System.out.println("Calling UserProfile to save...!");
//		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
//		if(fileName.contains("..")) {
//			System.out.println("Not a valid file");
//		}
//	//	userprofile.setimage(Base64.getEncoder().encodeToString(file.getBytes()));
//		return ups.saveUserProfile(userprofile);
//	}
	
	@PostMapping("/addUserProfile")
	public UserProfile addUser(@RequestBody UserProfile userprofile)  {
		System.out.println("Calling UserProfile to save...!");
		
		return ups.saveUserProfile(userprofile);
	}
	@GetMapping("/profileByid/{id}")
	public UserProfile profileByid(@PathVariable() int id){
		System.out.println("Calling... profile");
		return ups.getProfile(id);
	}
	@GetMapping("/profile/{search}")
	public Object findProfile(@PathVariable() String search){
		System.out.println("Calling... profile");
		return ups.getProfiles(search);
	}
	@GetMapping("/profiles")
	public List<UserProfile> findAllProfiles( ){
		return ups.getProfiles();
	}
	@GetMapping("/profiles/branch/{branch}")
	public List<Object> findAllProfilesByBranch(@PathVariable() String branch){
		System.out.println("Calling......!");
		return ups.getProfilesByBranch(branch);
	}
	
	
}
