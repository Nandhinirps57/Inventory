package com.inventory.springboot.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.springboot.model.User;
import com.inventory.springboot.model.UserProfile;



@Repository
@Transactional
public interface UserRepository  extends JpaRepository<User,Integer>{

	//@Modifying
	@Query("SELECT All u FROM User u WHERE u.email =?1 AND  u.password=?2") 
	Object findOneEmailAndPassword(String email, String password);

	Optional<User> findByuserprofile(int id);

	@Query("select All u,up FROM User u , UserProfile up where  u.userprofile=?1 ")
	Object findByUserProfile(int id);
	
	@Modifying
	@Query("update  User u set u.userprofile=?2 where u.id=?1")
	User updateUserProfile(int id, int id2);

	User findByName(String username);

	User findByEmail(String username);

	//update user set userprofile=userprofile.id where id='1';

	// @Query("SELECT e from Employee e where e.employeeName =:name AND e.employeeRole =:role")
	//select * from user  where email='prasannasurya12@gmail.com' and password='SSs@12';
	
	//User findByUp_id(int id);
  
}
