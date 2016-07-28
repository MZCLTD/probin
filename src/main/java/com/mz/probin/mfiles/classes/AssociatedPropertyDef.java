package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class AssociatedPropertyDef implements Serializable {

    @JsonProperty("PropertyDef")
    private int propertyDef;

    @JsonProperty("Required")
    private boolean required;

    public AssociatedPropertyDef() {
        this(0, false);
    }

    public AssociatedPropertyDef(int propertyDef, boolean required) {
        this.propertyDef = propertyDef;
        this.required = required;
    }

    public int getPropertyDef() {
        return propertyDef;
    }

    public void setPropertyDef(int propertyDef) {
        this.propertyDef = propertyDef;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
