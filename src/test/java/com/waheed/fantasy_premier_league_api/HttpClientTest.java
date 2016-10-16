package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by waheedelmiladi on 16/10/2016.
 */
public class HttpClientTest {

    private final String url = "http://test.com";
    private final String content = "Test content";
    private CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
    private CloseableHttpResponse response = mock(CloseableHttpResponse.class);
    private HttpEntity httpEntity = mock(HttpEntity.class);
    private HttpClient client = new HttpClient(httpClient);

    @org.junit.Before
    public void setUp() throws Exception {
        when(httpClient.execute(any(HttpGet.class))).thenReturn(response);
        when(response.getEntity()).thenReturn(httpEntity);
        when(httpEntity.getContent()).thenReturn(new ByteArrayInputStream(content.getBytes()));
    }

    @Test
    public void get() throws Exception {
        assertEquals(client.get(url), content);

        verify(response, times(1)).close();
    }

    @Test(expected=IOException.class)
    public void testFindByIdWhenNonExistent() throws Exception {
        when(httpEntity.getContent()).thenThrow(IOException.class);

        client.get(url);
    }
}