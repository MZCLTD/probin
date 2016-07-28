package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("Serial")
public class ExtendedObjectVersion implements Serializable {

    @JsonProperty("Properties")
    private PropertyValue[] properties;


    public ExtendedObjectVersion() {
        this(null);
    }

    public ExtendedObjectVersion(PropertyValue[] properties) {
        this.properties = properties;
    }

    public PropertyValue[] getProperties() {
        return properties;
    }

    public void setProperties(PropertyValue[] properties) {
        this.properties = properties;
    }
}
