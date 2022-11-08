package com.inventory.springboot.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String branch;
private String name;
private String email;
private String password;
//@JsonIgnore
//@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//@JoinColumn(name="userprofile")
private int userprofile;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}



public String getBranch() {
	return branch;
}

public void setBranch(String branch) {
	this.branch = branch;
}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getUserprofile() {
	return userprofile;
}

public void setUserprofile(int userprofile) {
	this.userprofile = userprofile;
}
 
public User(int id, String branch, String name, String email, String password, int userprofile) {
	
	this.id = id;
	this.branch = branch;
	this.name = name;
	this.email = email;
	this.password = password;
	this.userprofile = userprofile;
}

public User() {
	super();
}

@Override
public String toString() {
	return "User [id=" + id + ", branch=" + branch + ", name=" + name + ", email=" + email + ", password=" + password
			+ ", userprofile=" + userprofile + "]";
}


}
