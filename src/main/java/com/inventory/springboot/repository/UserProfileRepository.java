package com.inventory.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.springboot.model.UserProfile;

@Repository
@Transactional
public interface UserProfileRepository  extends JpaRepository<UserProfile,Integer>{

	Object findByuserName(String search);

	//@Query("SELECT All p FROM Product p WHERE p.id =?1 AND  p.name=?2") 
	//@Query("select All u,up FROM User u , UserProfile up where  u.userprofile=?1 ")
	@Query("SELECT All up from User u,UserProfile up where u.userprofile=up.id and u.branch=?1")
	List<Object> findAlluserprofileByBranch(String branch);
	//select about_me,address,userprofile.email,first_name from user,userprofile 
	//where user.up_id=userprofile.id and user.branch='salem';

	Object findByphoneNo(long num);
	
	@Query("SELECT All up from User u,UserProfile up where u.userprofile=up.id and u.id=?1")
	UserProfile findAlluserprofileByid(int id);
}
