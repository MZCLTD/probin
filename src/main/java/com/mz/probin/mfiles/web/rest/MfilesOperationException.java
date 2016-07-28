package com.mz.probin.mfiles.web.rest;


public class MfilesOperationException extends RuntimeException {

    public MfilesOperationException(Exception ex) {
        this(null, ex);
    }

    public MfilesOperationException(String msg, Exception ex) {
        super(msg, ex);
    }

    public MfilesOperationException(String msg) {
        this(msg, null);
    }

}
