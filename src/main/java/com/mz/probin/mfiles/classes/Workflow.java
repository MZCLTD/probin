package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Workflow implements Serializable {

    @JsonProperty("ID")
    private int id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("ObjectClass")
    private int objectClass;

    public Workflow() {
        this(0, null, 0);
    }

    public Workflow(int id, String name, int objectClass) {
        this.id = id;
        this.name = name;
        this.objectClass = objectClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getObjectClass() {
        return objectClass;
    }

    public void setObjectClass(int objectClass) {
        this.objectClass = objectClass;
    }
}
