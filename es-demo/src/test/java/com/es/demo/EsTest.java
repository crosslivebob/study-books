//package com.es.demo;
//
//import org.apache.http.HttpHost;
//import org.elasticsearch.action.get.GetRequest;
//import org.elasticsearch.action.get.GetResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//
//public class EsTest {
//
//    RestHighLevelClient client;
//
//    @BeforeEach
//    public void setUp() {
//        client = new RestHighLevelClient(
//                RestClient.builder(
//                        new HttpHost("localhost", 9200, "http")));
//    }
//
//    @Test
//    public void testGet() throws IOException {
//        GetRequest getRequest = new GetRequest(
//                "test", "2");
//        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
//        System.out.println(response.isExists());
//        System.out.println(response);
//    }
//
//
//}
