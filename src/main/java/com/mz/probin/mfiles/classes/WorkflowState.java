package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class WorkflowState implements Serializable {

    @JsonProperty("ID")
    private int id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Selectable")
    private boolean selectable;

    public WorkflowState() {
        this(0, null, false);
    }

    public WorkflowState(int id, String name, boolean selectable) {
        this.id = id;
        this.name = name;
        this.selectable = selectable;
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

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }
}
