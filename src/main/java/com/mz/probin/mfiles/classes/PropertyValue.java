package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PropertyValue implements Serializable {

    @JsonProperty("PropertyDef")
    private int propertyDef;

    @JsonProperty("TypedValue")
    private TypedValue typedValue;
    
    @JsonProperty("ContentType")
    @JsonIgnoreProperties
    private int contentType;

    public PropertyValue() {}

    public int getPropertyDef() {
        return propertyDef;
    }

    public void setPropertyDef(int propertyDef) {
        this.propertyDef = propertyDef;
    }

    public TypedValue getTypedValue() {
        return typedValue;
    }

    public void setTypedValue(TypedValue typedValue) {
        this.typedValue = typedValue;
    }
}
