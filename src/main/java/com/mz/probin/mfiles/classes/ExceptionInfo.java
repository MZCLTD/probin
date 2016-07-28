package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExceptionInfo implements Serializable {

    @JsonProperty("Message")
    private String message;

    @JsonProperty("InnerException")
    private ExceptionInfo innerException;

    @JsonProperty("Stack")
    private StackTraceElement[] stack;

    public ExceptionInfo() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExceptionInfo getInnerException() {
        return innerException;
    }

    public void setInnerException(ExceptionInfo innerException) {
        this.innerException = innerException;
    }

    public StackTraceElement[] getStack() {
        return stack;
    }

    public void setStack(StackTraceElement[] stack) {
        this.stack = stack;
    }
}
