package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectCreationInfo implements Serializable{

	@JsonProperty("PropertyValues")
	private PropertyValue[] propertyValues;
	
	@JsonProperty("Files")
	public UploadInfo[] files;

	@JsonProperty("Class")
	public int objectClass;

	public ObjectCreationInfo() { this(null, null); }

	public ObjectCreationInfo( PropertyValue[] propertyValues, UploadInfo[] files ) {
		this.propertyValues = propertyValues;
		this.files = files;
	}
	
	public ObjectCreationInfo( PropertyValue[] propertyValues ){
		this.propertyValues = propertyValues;
	}
	
	// getters and setters
	public PropertyValue[] getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(PropertyValue[] propertyValues) {
		this.propertyValues = propertyValues;
	}

	public UploadInfo[] getFiles() {
		return files;
	}

	public void setFiles(UploadInfo[] files) {
		this.files = files;
	}

	public int getObjectClass() {
		return objectClass;
	}

	public void setObjectClass(int objectClass) {
		this.objectClass = objectClass;
	}
}
