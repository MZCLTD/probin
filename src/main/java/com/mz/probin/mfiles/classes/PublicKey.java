package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class PublicKey implements Serializable {

    @JsonProperty("Exponent")
    private String exponent;

    @JsonProperty("Modulus")
    private String modulus;

    public PublicKey() {
        this(null, null);
    }

    public PublicKey(String exponent, String modulus) {
        this.exponent = exponent;
        this.modulus = modulus;
    }

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }

    public String getModulus() {
        return modulus;
    }

    public void setModulus(String modulus) {
        this.modulus = modulus;
    }
}
