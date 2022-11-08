package com.inventory.springboot.model;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="userprofile")
public class UserProfile {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String userName;
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	@Column(unique=true)
	private long phoneNo;
	private String postalCode;
	private String aboutMe;
	
//	@Column(columnDefinition="String")
//	private String image;
	//@JsonIgnore
	//@OneToOne(fetch=FetchType.LAZY, mappedBy="userprofile")
	//private User user;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
//	public String getimage() {
//		return image;
//	}
//	public void setimage(String image) {
//		this.image = image;
//	}
	
	
	public UserProfile(int id, String userName, String email, String firstName, String lastName, String address,
			String city, long phoneNo, String postalCode, String aboutMe) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.phoneNo = phoneNo;
		this.postalCode = postalCode;
		this.aboutMe = aboutMe;
		//this.image = image;
		//this.user = user;
	}
	public UserProfile() {
		
	}
	@Override
	public String toString() {
		return "UserProimage [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", phoneNo=" + phoneNo + ", postalCode=" + postalCode + ", aboutMe=" + aboutMe + ", image="
				+  "]";
	}
	
	
}
