package com.mz.probin.mfiles.web.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.mz.probin.constants.Constants;
import com.mz.probin.mfiles.classes.ObjType;
import com.mz.probin.mfiles.classes.ObjectClass;
import com.mz.probin.mfiles.classes.ObjectCreationInfo;
import com.mz.probin.mfiles.classes.ObjectVersion;
import com.mz.probin.mfiles.classes.ObjectWorkflowState;
import com.mz.probin.mfiles.classes.Results;
import com.mz.probin.util.JsonUtils;

/*@Component*/
public class MFilesHttpComponentsRestTemplate implements InitializingBean, DisposableBean {

    private static final Logger LOG = LoggerFactory.getLogger(MFilesRestTemplate.class);

    private static final int DEFAULT_MAX_TOTAL = 100;



    /**
     * The base url for the webservice
     */
    private String baseUrl;

    private PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();

    private int maxTotal = DEFAULT_MAX_TOTAL;

    private CloseableHttpClient httpClient;

    public MFilesHttpComponentsRestTemplate() {
        this(null);
    }

    public MFilesHttpComponentsRestTemplate(String baseUrl) {
        this.baseUrl = baseUrl;
        this.poolingHttpClientConnectionManager.setMaxTotal(this.maxTotal);
    }

    @Override
    public void afterPropertiesSet() {
        Assert.hasText(this.baseUrl, "Base url for MFilesRestTemplate must be provided");

        if (this.poolingHttpClientConnectionManager == null) {
            this.poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        }

        if (this.maxTotal > 0) {
            this.poolingHttpClientConnectionManager.setMaxTotal(this.maxTotal);
        }

        if (this.httpClient == null) {
            this.httpClient = HttpClients.custom()
                    .setConnectionManager(this.poolingHttpClientConnectionManager)
                    .build();
        }
    }

    @Override
    public void destroy() throws Exception {
        if (this.httpClient != null) {
            this.httpClient.close();
        }
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public PoolingHttpClientConnectionManager getPoolingHttpClientConnectionManager() {
        return poolingHttpClientConnectionManager;
    }

    public void setPoolingHttpClientConnectionManager(PoolingHttpClientConnectionManager poolingHttpClientConnectionManager) {
        this.poolingHttpClientConnectionManager = poolingHttpClientConnectionManager;
    }

    public int getMaxTotal() {
        return this.maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public File[] createFilesFromMultipart(Collection<MultipartFile> multipartFiles)  throws Exception {
        if (multipartFiles != null && multipartFiles.size() > 0) {
            List<File> retVal = new ArrayList<>(multipartFiles.size());

            for (MultipartFile file : multipartFiles) {
                //Should we assert if the file data is empty or null?
                //if (file.getBytes() == null || file.getBytes().length <= 0) {
                    //throw new MfilesOperationException("The byte array must not be null");
                //}

                File fileToUpload = createFileWithTemporaryName(file.getBytes(), file.getOriginalFilename());
                retVal.add(fileToUpload);
            }

            return retVal.toArray(new File[0]);
        }

        return new File[0];
    }
    
   

    private static File createFileWithTemporaryName(byte[] fileData, String filename) {
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

        final File fileToUpload = new File(tempDir + File.separator + tempFileName);

        try {
            FileUtils.writeByteArrayToFile(fileToUpload, fileData);
        }catch(Exception ex) {
            LOG.error("An exception occurred while writing byte array data to the file for upload", ex);
            throw new MfilesOperationException(ex.getMessage());
        } finally {

        }

        return fileToUpload;
    }

    @SuppressWarnings({ "unchecked" })
    public <T> List<T> multipartFormDataPostTemplate(String token, String url, Collection<MultipartFile> multipartFiles, Class<T> returnType) throws Exception {

        if (multipartFiles != null && multipartFiles.size() > 0) {
            File[] files = createFilesFromMultipart(multipartFiles);

            CloseableHttpClient client = HttpClients.createDefault();

            try {
                HttpPost httpPost = new HttpPost(getBaseUrl() + url);
                httpPost.setHeader("X-Authentication", token);
                MultipartEntityBuilder multipartBuilder = MultipartEntityBuilder.create();

                int i = 0;
                for (File file : files) {
                    final FileBody fileBody = new FileBody(file);
                    multipartBuilder.addPart("file" + (++i), fileBody);
                }

                org.apache.http.HttpEntity multipart = multipartBuilder.build();
                httpPost.setEntity(multipart);

                CloseableHttpResponse response = client.execute(httpPost);
                try {
                    org.apache.http.HttpEntity resEntity = response.getEntity();

                    if (resEntity != null) {
                        if (files.length > 1) {
                            //return JsonUtils.readValue(resEntity.getContent(), List.class);
                            return JsonUtils.readValue(resEntity.getContent(), new TypeReference<List<T>>() {});
                        }
                        else {
                            final T t = JsonUtils.readValue(resEntity.getContent(), returnType);
                            return Lists.newArrayList(t);
                        }
                    }

                    EntityUtils.consume(resEntity);

                } finally {
                    response.close();
                }

            } finally {
                client.close();
                //delete the files
                deleteFiles(files);
            }
        }

        return Collections.EMPTY_LIST;
    }
    
    
    public List<ObjectClass> getObjectClasses(String token, String objectType) throws Exception {

        final StringBuilder url = getFullUrl(Constants.OBJECT_CLASSES_URL);

        if (StringUtils.isNotBlank(objectType)) {
            url.append("?objtype=").append(objectType);
        }

        HttpGet httpGet = createHttpGet(token, url.toString());

        return executeGetAndReturnList(httpGet, new TypeReference<List<ObjectClass>>() {});
    }

    public Results<ObjectVersion> getAllObjects(String token) throws Exception {
        final StringBuilder url = getFullUrl(Constants.OBJECT_LIST_URL);
        HttpGet httpGet = createHttpGet(token, url.toString());

        Results<ObjectVersion> results = executeGet(httpGet, new TypeReference<Results<ObjectVersion>>() {});
        if (results != null) {
            return results;
        }

        return new Results<>();
    }

    public List<ObjType> getObjectTypes(String token, String type) throws Exception {
        if (type != null) {
            type = type.toLowerCase();
            if ( (!type.equalsIgnoreCase("real")) && (!type.equalsIgnoreCase("valuelist")) ) {
                type = "both";
            }
        } else { type = "both"; }

        final StringBuilder url = getFullUrl(Constants.OBJECT_TYPES_URL).append("?type=").append(type);
        HttpGet httpGet = createHttpGet(token, url.toString());

        return executeGetAndReturnList(httpGet, new TypeReference<List<ObjType>>() {});
    }

    @SuppressWarnings("unchecked")
	private <T> List<T> executeGetAndReturnList(HttpGet httpGet, TypeReference<List<T>> typeRef) throws Exception {
        List<T> list = executeGet(httpGet, typeRef);
        if (list != null ) {
            return list;
        }

        return Collections.EMPTY_LIST;
    }

    private <T> T executeGet(HttpGet httpGet, TypeReference<T> typeRef) throws Exception {
        CloseableHttpResponse response = this.httpClient.execute(httpGet, HttpClientContext.create());

        try {
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                return JsonUtils.readValue(responseEntity.getContent(), typeRef);
            }
        }
        finally {
            response.close();
        }

        return null;
    }
    
    private <T> T executeGet1(HttpGet httpGet, TypeReference<T> typeRef) throws Exception {
        CloseableHttpResponse response = this.httpClient.execute(httpGet, HttpClientContext.create());

        try {
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                return JsonUtils.readValue(responseEntity.getContent(), typeRef);
            }
        }
        finally {
            response.close();
        }

        return null;
    }
    
   // get current workflow state
    
   public ObjectWorkflowState getObjectWorkflow( String token, int objectType, String objectId, int objectVersion ) throws Exception{
    	String url = Constants.HOST+Constants.OBJECT_CREATION_URL+objectType+"/"+objectId+"/"+objectVersion+"/"+"workflowstate";
    	
    	CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);
            httpget.setHeader("X-Authentication", token);

            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = responseBody;
            
            ObjectWorkflowState objectWorkflow = mapper.readValue(jsonInString, ObjectWorkflowState.class);
            
            return objectWorkflow;
            
        } finally {
            httpclient.close();
        }
        
       // return new ObjectWorkflowState();
    }

    public ObjectVersion createObjectInfo( String token, ObjectCreationInfo info, int objectType ) throws Exception {
        final StringBuilder url = getFullUrl(Constants.OBJECT_CREATION_URL + objectType);
        final StringEntity entity = new StringEntity(JsonUtils.writeValueAsString(info));

        HttpPost httpPost = createHttpPost(token, url.toString());
        httpPost.setEntity(entity);

        CloseableHttpResponse response = this.httpClient.execute(httpPost, HttpClientContext.create());
        try {
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                return JsonUtils.readValue(responseEntity.getContent(), ObjectVersion.class);
            }
        }
        finally {
            response.close();
        }

        return new ObjectVersion();
    }

    private StringBuilder getFullUrl(String url) {
        return new StringBuilder(getBaseUrl()).append(url);
    }

    private static HttpGet createHttpGet(String token, String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("X-Authentication", token);

        return httpGet;
    }

    private static HttpPost createHttpPost(String token, String url) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("X-Authentication", token);

        return httpPost;
    }

    private static void deleteFiles(File[] files) throws Exception {
        if (files != null && files.length > 0) {
            for (File file : files) {
                FileUtils.forceDelete(file);
            }
        }
    }

    private void doMultipartFormDataPostRequest(String token, String url, byte[] fileData, String filename) throws Exception {
        //Create an array of files with the data


        CloseableHttpClient client = HttpClients.createDefault();

        try {
            HttpPost httpPost = new HttpPost(getBaseUrl() + url );
            httpPost.setHeader("X-Authentication", token);


            MultipartEntityBuilder multipartBuilder = MultipartEntityBuilder.create();

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

            final File fileToUpload = new File(tempDir + File.separator + tempFileName);

            try {
                FileUtils.writeByteArrayToFile(fileToUpload, fileData);
            }catch(Exception ex) {
                LOG.error("An exception occurred while writing byte array data to the file for upload", ex);
                throw new MfilesOperationException(ex.getMessage());
            } finally {

            }

            final FileBody fileBody = new FileBody(fileToUpload);

            multipartBuilder.addPart("file", fileBody);

            //OR
            //multipartBuilder.addBinaryBody("file", file, ContentType.APPLICATION_OCTET_STREAM, "file.ext");

            org.apache.http.HttpEntity multipart = multipartBuilder.build();
            httpPost.setEntity(multipart);

            System.out.println("executing file upload request " + httpPost.getRequestLine());

            CloseableHttpResponse response = client.execute(httpPost);
            try {
                System.out.println("----------------------------------------");
                System.out.println("---------Response from server-----------");
                System.out.println(response.getStatusLine());
                System.out.println("----------------------------------------");

                org.apache.http.HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(resEntity.getContent()));
                    String output = null;

                    while ((output = br.readLine()) != null) {
                        System.out.println(output);
                    }
                }

                EntityUtils.consume(resEntity);

            } finally {
                response.close();
            }
        } finally {
            client.close();
        }
    }
}
