package com.inventory.springboot.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.inventory.springboot.controller.UserController;
import com.inventory.springboot.model.Product;
import com.inventory.springboot.model.User;
import com.inventory.springboot.repository.UserRepository;
import com.inventory.springboot.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class  UserTest {
	
	@MockBean
    private  UserRepository ur;
	
	@Autowired
	 private  UserRepository uro;
	
	@Autowired
    private UserController Uc;
	
	@Autowired
	private UserService ps;
	
	@Test
	public void addUserTest() {
		User u=new User(1,"rps","rps12@gmail.com","r14rdk","salem",2);
	    when(ur.save(u)).thenReturn(u);
	    User check=Uc.addUser(u);
		Assertions.assertNotNull(check,"no not null");
	}
	@Test
	public void updateUserTest() {
		User u=new User(1,"rps","rps12@gmail.com","r14rdk","salem",2);
		 when(ur.updateUserProfile(1,3)).thenReturn(u);
		User Check=Uc.updateUser(u,3);
	   assertNotNull(Check);
	}
	@Test
	 public void loginTest() {
		User u1=new User(5,"rps","rps12@gmail.com","r14rdk","salem",2);	
		when(ur. findOneEmailAndPassword("prasanna12@gmail.com","PAsa12@"))
		.thenReturn(u1);
	User u2=	(User) Uc.login("prasanna12@gmail.com","PAsa12@");
		
	Object check=uro.findOneEmailAndPassword("prasanna12@gmail.com","PAsa12@");
		   User k=(User) check;
		    	assertThat(k.getId()).isEqualTo(u2.getId());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
