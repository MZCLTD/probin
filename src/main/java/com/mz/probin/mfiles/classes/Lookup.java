package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lookup {

    @JsonProperty("Deleted")
    private boolean deleted;

    @JsonProperty("DisplayValue")
    private String displayValue;

    @JsonProperty("Hidden")
    private boolean hidden;

    @JsonProperty("Item")
    private int item;

    @JsonProperty("Version")
    private int version;


    public Lookup() {}
    
    public Lookup(int item) {
		super();
		this.item = item;
	}

	public Lookup(boolean deleted, String displayValue, boolean hidden,
			int item, int version) {
		super();
		this.deleted = deleted;
		this.displayValue = displayValue;
		this.hidden = hidden;
		this.item = item;
		this.version = version;
	}



	public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
