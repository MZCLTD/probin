package com.mz.probin.web.servlet.init;

import com.mz.probin.config.SpringRootConfig;
import com.mz.probin.config.SpringSecurityConfig;
import com.mz.probin.config.SpringWebMvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;


public class WebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { SpringRootConfig.class, SpringSecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { SpringWebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD));
    }

    private static final String LOCATION = "/home/redsofts/tmp/";

    private static final long MAX_FILE_SIZE = 5242880L; //5MB

    private static final long MAX_REQUEST_SIZE = 20971520L; //20MB

    private static final int FILE_SIZE_THRESHOLD = 0; //Size threshold after which files will be written to disk
}
