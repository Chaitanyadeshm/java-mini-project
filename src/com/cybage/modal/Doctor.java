package com.cybage.modal;

import java.util.List;

public class Doctor {
	private int userId;
	private List<String> specializations;
	private String firstname;
	private String lastname;
	private String email;
	private int mobile;
	private String password;
	private int active;
	private String profileUrl;
	private String city;
	public Doctor(int userId, List<String> specializations, String firstname, String lastname, String email, int mobile,
			String password, int active, String profileUrl, String city) {
		super();
		this.userId = userId;
		this.specializations = specializations;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.active = active;
		this.profileUrl = profileUrl;
		this.city = city;
	}
	public Doctor() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<String> getSpecializations() {
		return specializations;
	}
	public void setSpecializations(List<String> list) {
		this.specializations = list;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
