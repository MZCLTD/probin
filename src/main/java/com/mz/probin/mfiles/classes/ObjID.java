package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class ObjID implements Serializable {

    @JsonProperty("ID")
    private int id;

    @JsonProperty("Type")
    private int type;

    public ObjID() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
