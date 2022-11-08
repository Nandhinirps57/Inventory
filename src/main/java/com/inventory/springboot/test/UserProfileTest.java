package com.inventory.springboot.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.inventory.springboot.controller. UserProfileController;
import com.inventory.springboot.model.Product;
import com.inventory.springboot.model. UserProfile;
import com.inventory.springboot.repository. UserProfileRepository;
import com.inventory.springboot.service. UserProfileService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class  UserProfileTest {


	@MockBean
    private   UserProfileRepository upr;
	
	@Autowired
	 private   UserProfileRepository upro;
	
	@Autowired
    private  UserProfileController upc;
	
	@Autowired
	private  UserProfileService ps;
	
	@Test
	public void  addUserProfileTest() {
		 UserProfile u=new  UserProfile(1,"rps","rps12@gmail.com","prasanna","surya","address","salem",9876543113l,"765-098","secret");
	    when(upr.save(u)).thenReturn(u);
	     UserProfile check=upc.addUser(u);
		Assertions.assertNotNull(check,"no not null");
	}
	@Test
	public void findprofileByIdTest() {
		 UserProfile u=new  UserProfile(1,"rps","rps12@gmail.com","prasanna","surya","address","salem",9876543113l,"765-098","secret");
		when(upr.findAlluserprofileByid(1)).thenReturn(u);
	
		assertNotNull(upc.profileByid(1));
	}
	@Test
	public void findAllprofileTest() {
		 UserProfile u=new  UserProfile(1,"rps","rps12@gmail.com","prasanna","surya","address","salem",9876543113l,"765-098","secret");
		 List<UserProfile> list;
		 list=upro.findAll();
		when(upr.findAll()).thenReturn(list);
	
		assertNotNull(upc.findAllProfiles());
		
	}
	@Test
	public void findProfileTest() {
		 UserProfile u=new  UserProfile(1,"rps","rps12@gmail.com","prasanna","surya","address","salem",9876543113l,"765-098","secret");
		when(upro.findByuserName("RpsAfful")).thenReturn(u);
		assertNotNull(upc.findProfile("RpsAfful"));
		
	}
	@Test
	public void findAllProfileByBranchTest() {
		
		 List<Object> list = new ArrayList<Object>();
		 list.add(new  UserProfile(1,"rps","rps12@gmail.com","prasanna","surya","address","salem",9876543113l,"765-098","secret"));
		 list.add(new  UserProfile(1,"rps","rps12@gmail.com","prasanna","surya","address","salem",9876543113l,"765-098","secret"));
		when(upr.findAlluserprofileByBranch("salem")).thenReturn(list);
		assertNotNull(upc.findAllProfilesByBranch("salem"));
	}
	   @Test
	    public void updateUserTest() {
	UserProfile up1=new  UserProfile(1,"RpsAfful","rps12@gmail.com","prasanna","surya","address","salem",9876543113l,"765-098","secret");
		   Optional<UserProfile> uP=Optional.ofNullable(new  UserProfile(1,"rps","rps12@gmail.com","prasanna","surya","address","salem",9876543113l,"765-098","secret"));
	    when(upr.findById(1)).thenReturn(uP);
	
	     upc.updateUser(up1);
	    assertThat(up1.getUserName()).isEqualTo("RpsAfful");
	  when(upr.save(up1)).thenReturn(up1);
	  assertNotNull(upr.save(up1))  ;
	    	
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
