package com.mz.probin.mfiles.classes;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WebServiceError implements Serializable {

    @JsonProperty("Status")
    private int status;

    @JsonProperty("Method")
    private String method;

    @JsonProperty("URL")
    private String url;

    @JsonProperty("Exception")
    private ExceptionInfo exception;

    public WebServiceError() {}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ExceptionInfo getException() {
        return exception;
    }

    public void setException(ExceptionInfo exception) {
        this.exception = exception;
    }
}
