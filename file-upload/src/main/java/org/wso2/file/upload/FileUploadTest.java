package org.wso2.file.upload;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

public class FileUploadTest {

    public static void main(String[] args) throws Exception {

        System.setProperty("javax.net.ssl.trustStore",
                "/home/firzhan/wso2/PUBLIC_BRANCH/product-bps/modules/distribution/target/wso2bps-3.5" +
                        ".1-SNAPSHOT/repository/resources/security/client-truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "wso2carbon");
        System.setProperty("javax.net.ssl.trustStoreType", "jks");

        CloseableHttpClient httpClient = HttpClients.createDefault();
        //HttpPost uploadFile = new HttpPost("https://localhost:9443/bpmn/runtime/tasks/49/variables/");
        HttpPut uploadFile = new HttpPut("https://localhost:9443/bpmn/runtime/tasks/49/variables/taskBinaryVar1");
        uploadFile.setHeader("Authorization", "Basic YWRtaW46YWRtaW4=");
        uploadFile.setHeader("Accept", "application/json");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("name", "taskBinaryVar1");
        builder.addTextBody("type", "binary");
        builder.addTextBody("scope", "global");
        builder.addBinaryBody("file", new File("/home/firzhan/Desktop/abcde.zip"), ContentType.APPLICATION_OCTET_STREAM,
                "abcde.zip");
        HttpEntity multipart = builder.build();


        uploadFile.setEntity(multipart);

        CloseableHttpResponse response = httpClient.execute(uploadFile);
        HttpEntity responseEntity = response.getEntity();

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(responseEntity.getContent()), 65728);
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        catch (IOException e) { e.printStackTrace(); }
        catch (Exception e) { e.printStackTrace(); }


        System.out.println("finalResult " + sb.toString());
    }
}
