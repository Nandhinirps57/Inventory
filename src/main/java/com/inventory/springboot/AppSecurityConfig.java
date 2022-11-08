package com.inventory.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
public class AppSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	private  String url="/login/email={email}&password={password}";
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		System.out.println("Which called first..");
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}

	
	/*@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		List<UserDetails> users=new ArrayList<>();
		
		users.add(User.withDefaultPasswordEncoder().username("Rps").password("123").roles("USER").build());
		return new InMemoryUserDetailsManager(users);
	}*/
	
	

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//        .authorizeRequests()
//        .antMatchers(url,"/products/**","/product/**","/addProduct/{add}","/update","/delete/{id}","/addUser","/updateUser/{id}",
//	    		"/getUser/{id}","/profiles","/profiles/branch/{branch}",
//	    		"/profile/{search}","/profileByid/{id}","/addUserProfile","/profileUpdate")
//	    .permitAll() .anyRequest().fullyAuthenticated()
//		.and()
//		.formLogin().loginPage("http://localhost:8081/log-in").permitAll();
//		
//	   
//	
//	
//		
//	}
	/*.authorizeRequests()
    .antMatchers(url,"/products/**","/product/**","/addProduct/{add}","/update","/delete/{id}","/addUser","/updateUser/{id}",
    		"/getUser/{id}","/profiles","/profiles/branch/{branch}",
    		"/profile/{search}","/profileByid/{id}","/addUserProfile","/profileUpdate")
    .permitAll().anyRequest().authenticated() ;*/
}
