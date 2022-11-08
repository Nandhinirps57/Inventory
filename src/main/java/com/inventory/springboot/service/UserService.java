package com.inventory.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inventory.springboot.AppSecurityConfig;
import com.inventory.springboot.model.User;
import com.inventory.springboot.repository.UserProfileRepository;
import com.inventory.springboot.repository.UserRepository;

@Service
public class UserService  implements UserDetailsService{
	
	private AppSecurityConfig asc= new AppSecurityConfig();
	@Autowired
	UserProfileRepository upr1;
	@Autowired
    UserRepository ur;
	
	public User saveUser(User user) {
		
		System.out.println("Saving User...!");
		
		return ur.save(user);
		
		}
	
public Object getlogin(String email, String password) {
 Object user= ur.findOneEmailAndPassword(email,password);  
 System.out.println(user);

return  user;

	}


	
	public User updateUser(User user,int id) {
		//System.out.println(user.getId());
		//System.out.println(user.getUserprofile());
	 //  upr1.save(user.getUserprofile());
	  // System.out.println("problem....");
		
		return ur.updateUserProfile(user.getId(),id);
	
	}

	public Object getUserDetails(int id) {
		  	System.out.println("id...."+id);
//	  return ur.findByUserProfile(id);
	
		//return ur.findById(id).orElseThrow();
		
		return upr1.findAlluserprofileByid(id);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("User service...!"+username);
		User user= ur.findByEmail(username);
		
		 if(user==null) {
			 throw new  UsernameNotFoundException("user 404");
			
		 } 
		 System.out.println("Service Layer "+user.getEmail());
		
		return new UserPrincipal(user);
	}

	

}
