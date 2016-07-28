package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Vault implements Serializable {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("GUID")
    private String guid;

    @JsonProperty("AuthenticationUtils")
    private String authentication;

    public Vault() {
        this(null, null, null);
    }

    public Vault(String name, String guid, String authentication) {
        this.name = name;
        this.guid = guid;
        this.authentication = authentication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }
}
