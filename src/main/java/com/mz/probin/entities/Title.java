package com.mz.probin.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TITLE")
public class Title implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="TITLE_ID")
	private long titleId;
	
	@Column(name="TITLE")
	private String title;
	
	// getters and setters
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
