package com.niit.CollaborationBackEnd.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "c_user")
@Component
public class User extends BaseDomain
{

	@Id
	private String id;
	private String nam;
	private String mail;
	private String dob;
	private String mobile;
	private String psswrd;
	private char isOnline;
	private String gender;
	private String role;
	private String Address;
	private char status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public User() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		Date date = new Date();

		dob = dateFormat.format(date);
		System.out.println("dateofbirth : " + dob);
	}

	public char getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public String getmail() {
		return mail;
	}

	public void setmail(String mail) {
		this.mail = mail;
	}

	public String getmobile() {
		return mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setmobile(String mobile) {
		this.mobile = mobile;
	}

	
	
	public String getPsswrd() {
		return psswrd;
	}

	public void setPsswrd(String psswrd) {
		this.psswrd = psswrd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}