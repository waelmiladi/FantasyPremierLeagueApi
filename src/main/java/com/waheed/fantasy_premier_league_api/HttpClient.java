package com.waheed.fantasy_premier_league_api;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

public class HttpClient {
    public String get(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = execute(request);
        return getContent(response);
    }

    private CloseableHttpResponse execute(HttpGet request) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        return httpclient.execute(request);
    }

    private String getContent(CloseableHttpResponse response) throws IOException {
        String content = "";
        try {
            HttpEntity entity = response.getEntity();
            content = inputStreamToString(entity.getContent());
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }
        return content;
    }

    private String inputStreamToString(InputStream inputStream) {
        java.util.Scanner s = new java.util.Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
