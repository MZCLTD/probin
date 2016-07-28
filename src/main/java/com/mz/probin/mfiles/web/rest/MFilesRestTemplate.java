package com.mz.probin.mfiles.web.rest;

import com.mz.probin.constants.Constants;
import com.mz.probin.mfiles.classes.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Collections;
import java.util.List;


public class MFilesRestTemplate  {

    private static final Logger LOG = LoggerFactory.getLogger(MFilesRestTemplate.class);

    private RestTemplate restTemplate;

    /**
     * The base url for the webservice
     */
    private String baseUrl;

    public MFilesRestTemplate() {
        this.restTemplate = createRestTemplate(new HttpComponentsClientHttpRequestFactory());
        //this.restTemplate = createRestTemplate(null);
    }

    public MFilesRestTemplate(String baseUrl) {
        this();
        Assert.hasText(baseUrl, "Base url for MFilesRestTemplate must be provided");
        this.baseUrl = baseUrl;
    }

    public MFilesRestTemplate(RestTemplate restTemplate) {
        Assert.notNull(restTemplate, "RestTemplate must not be null");
        this.restTemplate = restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        Assert.notNull(restTemplate, "RestTemplate must not be null");
        this.restTemplate = restTemplate;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public RestTemplate getRestTemplate() {
        return this.restTemplate;
    }

    //@Override
    public void afterPropertiesSet() {
        Assert.hasText(this.baseUrl, "Base url for MFilesRestTemplate must be provided");

        if (this.restTemplate == null) {
            this.restTemplate = createRestTemplate(new HttpComponentsClientHttpRequestFactory());
        }
    }

    /**
     *
     * @param token the token provided by MFiles for the upload process
     * @param fileData the byte array of the data in the file
     * @param filename the name of the file. This should contain the file extension also.
     * @return
     * @throws MfilesOperationException
     */
    public UploadInfo getUploadInfo(String token, byte[] fileData, String filename) throws MfilesOperationException {
        if (fileData == null || fileData.length <= 0) {
            throw new MfilesOperationException("The byte array must not be null");
        }

        if (StringUtils.isBlank(filename)) {
            throw new MfilesOperationException( "Filename must not be blank or null..." );
        }

        File tempDir = FileUtils.getTempDirectory();
        String reversedFilename = StringUtils.reverse(filename);
        //get the first '.'
        int dotIndex = reversedFilename.indexOf('.');
        String extension = reversedFilename.substring(0, (dotIndex + 1));
        extension = StringUtils.reverse(extension);

        //Generate a random string to append to the name of the file
        //We do this to prevent a situation whereby multiple users
        //upload files that have the same name and extension.
        String tempFileName = filename.substring(0, filename.length() - extension.length()) + "_" + System.currentTimeMillis();

        tempFileName += extension;

        File fileToUpload = new File(tempDir + File.separator + tempFileName);

        try {
            FileUtils.writeByteArrayToFile(fileToUpload, fileData);
        }catch(Exception ex) {
            LOG.error("An exception occurred while writing byte array data to the file for upload", ex);
            throw new MfilesOperationException(ex.getMessage());
        } finally {

        }

        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("file", new FileSystemResource(fileToUpload));

        HttpHeaders headers =  createMultipartFormDataHeaders(token);
        HttpEntity<MultiValueMap<String, Object>> httpRequestEntity = createHttpEntityWithParts(headers, parts);

        //RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UploadInfo> response =
                getRestTemplate().exchange(getBaseUrl() + Constants.UPLOAD_URL,
                        HttpMethod.POST, httpRequestEntity, UploadInfo.class);

        //Delete the file from the temporary directory
        deleteFile(fileToUpload);

        return response.getBody();
    }

    public ObjectVersion createObject(String token, int objectType) {
        return null;
    }

    /**
     *
     * @param token
     * @param type 'real', 'valuelist' and 'both' are used for
     *             fetching real object types, non-object type valuelists
     *             and both respectively. The default is 'both'.
     * @return
     */
    public ObjType[] getObjectTypes(String token, String type) {
       /* if (type != null) {
            type = type.toLowerCase();
            if ( (!type.equalsIgnoreCase("real")) && (!type.equalsIgnoreCase("valuelist")) ) {
                type = "both";
            }
        } else { type = "both"; }

        HttpHeaders headers =  createHeaders(token);

        final String url = getBaseUrl() + Constants.OBJECT_TYPES_URL + "?type=" + type;

        ResponseEntity<List> response =
                getRestTemplate().exchange(url, HttpMethod.GET,
                        new HttpEntity(new HttpEntity<>(Collections.EMPTY_MAP, headers)), List.class);

        if (response.getBody() != null) {
            return (ObjType[]) response.getBody().toArray();
        }*/

        return new ObjType[0];
    }

    public List<ObjectClass> getObjectClasses(String token, String objectType) {
        HttpHeaders headers =  createHeaders(token);
        final StringBuilder url = getFullUrl(Constants.OBJECT_CLASSES_URL);

        if (StringUtils.isNotBlank(objectType)) {
            url.append("?objtype=").append(objectType);
        }

        ResponseEntity<List> response =
                getRestTemplate().exchange(url.toString(), HttpMethod.GET,
                        new HttpEntity(new HttpEntity<>(Collections.EMPTY_MAP, headers)), List.class);

        return response.getBody();
    }

    public List<ClassGroup> getClassGroups(String token) {
        HttpHeaders headers =  createHeaders(token);
        final StringBuilder url = getFullUrl(Constants.OBJECT_CLASSES_URL).append("?bygroup=true");

        ResponseEntity<List> response =
                getRestTemplate().exchange(url.toString(), HttpMethod.GET,
                        new HttpEntity(new HttpEntity<>(Collections.EMPTY_MAP, headers)), List.class);

        return response.getBody();
    }

    private StringBuilder getFullUrl(String url) {
        return new StringBuilder(getBaseUrl()).append(url);
    }

    private static HttpHeaders createMultipartFormDataHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set(Constants.X_AUTHENTICATION_HEADER, token);

        return headers;
    }

    private static HttpHeaders createHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constants.X_AUTHENTICATION_HEADER, token);

        return headers;
    }

    private static HttpEntity<MultiValueMap<String, Object>> createHttpEntityWithParts(HttpHeaders headers, MultiValueMap<String, Object> parts) {
        return new HttpEntity<>(parts, headers);
    }

    private static RestTemplate createRestTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        if (clientHttpRequestFactory == null) {
            return new RestTemplate();
        }

        return new RestTemplate(clientHttpRequestFactory);
    }

    private static RestTemplate createRestTemplate() {
        return createRestTemplate(null);
    }

    private static void deleteFile(File fileToDelete) {
        if (fileToDelete != null && fileToDelete.exists()) {
            fileToDelete.delete();
        }
    }

    //TODO - static method to create the temporary file name, 2. Delete the file after uploading
}
