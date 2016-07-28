package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@SuppressWarnings("Serial")
public class View implements Serializable {

    @JsonProperty("ID")
    private int id;

    @JsonProperty("Common")
    private boolean common;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Parent")
    private int parent;

    @JsonProperty("ViewLocation")
    private ViewLocation viewLocation;

    public View() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCommon() {
        return common;
    }

    public void setCommon(boolean common) {
        this.common = common;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public ViewLocation getViewLocation() {
        return viewLocation;
    }

    public void setViewLocation(ViewLocation viewLocation) {
        this.viewLocation = viewLocation;
    }
}
