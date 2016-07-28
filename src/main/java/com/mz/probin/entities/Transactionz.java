package com.mz.probin.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TRANSACTIONS")
public class Transactionz implements Serializable {

	/**
	 *   @author Diejomaoh E. Richards
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="SERIAL_NUMBER")
	private long serialNumber;
	
	@Column(name="USER_NAME")
	private String username;
	
	@Column(name="TRANSACTION_ID")
	private String transactionId;
	
	@Column(name="TRANSACTION_DATE")
	private String transactionDateTime;
	
	/*@Column(name="STATUS")
	private String status;*/
	
	@Column(name="OBJECT_TYPE")
	private int objectType;
	
	@Column(name="OBJECT_ID")
	private String objectId;
	
	@Column(name="OBJECT_VERSION")
	private int objectVersion;
	
	@Transient
	private List<Transactionz> transactionsList;
	
	// getters and setters
	public long getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Transactionz> getTransactionsList() {
		return transactionsList;
	}
	public void setTransactionsList(List<Transactionz> transactionsList) {
		this.transactionsList = transactionsList;
	}
	public int getObjectType() {
		return objectType;
	}
	public void setObjectType(int objectType) {
		this.objectType = objectType;
	}
	public int getObjectVersion() {
		return objectVersion;
	}
	public void setObjectVersion(int objectVersion) {
		this.objectVersion = objectVersion;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	
	
	

}
