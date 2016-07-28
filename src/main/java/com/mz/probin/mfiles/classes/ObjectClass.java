package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "MFILES_OBJECT_CLASS")
public class ObjectClass implements Serializable {

    @JsonProperty("ID")
    @Column(name = "OBJECT_CLASS_ID", nullable = false, unique = true)
    @Id
    private int id;

    @Column(name = "OBJECT_CLASS_NAME", nullable = false, length = 150)
    @JsonProperty("Name")
    private String name;

    @Column(name = "OBJ_NAME_PROP_DEF")
    @JsonProperty("NamePropertyDef")
    private int namePropertyDef;

    @Column(name = "OBJ_WORKFLOW")
    @JsonProperty("Workflow")
    private int workflow;

    @Column(name = "OBJ_TYPE")
    @JsonProperty("ObjType")
    private int objType;

    public ObjectClass() {}

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

    public int getNamePropertyDef() {
        return namePropertyDef;
    }

    public void setNamePropertyDef(int namePropertyDef) {
        this.namePropertyDef = namePropertyDef;
    }

    public int getWorkflow() {
        return workflow;
    }

    public void setWorkflow(int workflow) {
        this.workflow = workflow;
    }

    public int getObjType() {
        return objType;
    }

    public void setObjType(int objType) {
        this.objType = objType;
    }
}
