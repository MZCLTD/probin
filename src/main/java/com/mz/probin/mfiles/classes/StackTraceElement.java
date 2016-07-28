package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StackTraceElement implements Serializable {

    @JsonProperty("FileName")
    private String fileName;

    @JsonProperty("LineNumber")
    private int lineNumber;

    @JsonProperty("ClassName")
    private String className;

    @JsonProperty("MethodName")
    private String methodName;

    public StackTraceElement() {}

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
