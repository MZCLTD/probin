package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TypedValue implements Serializable {

	@JsonProperty("DataType")
	private int dataType;

	@JsonProperty("HasValue")
	private boolean hasValue;

	@JsonProperty("Value")
	private Object value;

	@JsonProperty("Lookup")
    private Lookup lookup;

	@JsonProperty("Lookups")
	private Lookup[] lookups;

	@JsonProperty("DisplayValue")
	private String displayValue;

	@JsonProperty("SortingKey")
	private String sortingKey;

	@JsonProperty("SerializedValue")
	private String serializedValue;
    

	public TypedValue() {}

	public TypedValue(int dataType, Object value) {
		this.dataType = dataType;
		this.value = value;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public boolean isHasValue() {
		return hasValue;
	}

	public void setHasValue(boolean hasValue) {
		this.hasValue = hasValue;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Lookup getLookup() {
		return lookup;
	}

	public void setLookup(Lookup lookup) {
		this.lookup = lookup;
	}

	public Lookup[] getLookups() {
		return lookups;
	}

	public void setLookups(Lookup[] lookups) {
		this.lookups = lookups;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getSortingKey() {
		return sortingKey;
	}

	public void setSortingKey(String sortingKey) {
		this.sortingKey = sortingKey;
	}

	public String getSerializedValue() {
		return serializedValue;
	}

	public void setSerializedValue(String serializedValue) {
		this.serializedValue = serializedValue;
	}
}
