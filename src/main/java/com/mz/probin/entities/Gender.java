package com.mz.probin.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="GENDER")
public class Gender implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="GENDER_ID")
	private long genderId;
	
	@Column(name="GENDER")
	private String gender;
	
	// getters and setters
	public long getGenderId() {
		return genderId;
	}
	public void setGenderId(long genderId) {
		this.genderId = genderId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	

}
