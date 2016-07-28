package com.mz.probin.entities.security;

import com.mz.probin.entities.Gender;
import com.mz.probin.entities.Title;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="USER_ACCOUNT")
public class UserAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name="TITLE")
	private long titleId;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="GENDER")
	private long genderId;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TELEPHONE_NUMBER")
	private String telephoneNumber;
	
	@Column(name="CONTACT_ADDRESS")
	private String contactAddress;
	
	/*
	 * These are transient variables
	 * 
	 */
	
	@Transient
	private List<Title> titleList;
	
	@Transient
	private List<Gender> genderList;
	
	@Transient
	private String username;
	
	@Transient
	private String password;
	
	// getters and setters
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTitleId() {
		return titleId;
	}
	public void setTitleId(long titleId) {
		this.titleId = titleId;
	}
	public long getGenderId() {
		return genderId;
	}
	public void setGenderId(long genderId) {
		this.genderId = genderId;
	}
	public List<Title> getTitleList() {
		return titleList;
	}
	public void setTitleList(List<Title> titleList) {
		this.titleList = titleList;
	}
	public List<Gender> getGenderList() {
		return genderList;
	}
	public void setGenderList(List<Gender> genderList) {
		this.genderList = genderList;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
