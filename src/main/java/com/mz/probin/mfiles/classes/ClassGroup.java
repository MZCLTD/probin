package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ClassGroup implements Serializable {

    @JsonProperty("Name")
    private String name;

    public ClassGroup() {
        this(null);
    }

    public ClassGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
