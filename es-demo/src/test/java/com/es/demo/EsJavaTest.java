package com.es.demo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkResponseItem;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

public class EsJavaTest {

    ElasticsearchClient client;

    @BeforeEach
    public void setUp() {
        // Create the low-level client
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200))
                .setHttpClientConfigCallback(builder -> builder.setDefaultCredentialsProvider(this.init()))
                .build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        // And create the API client
        client = new ElasticsearchClient(transport);
    }

    private CredentialsProvider init() {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "123456"));
        return credentialsProvider;
    }

    @Test
    public void testGet() throws IOException {
        GetRequest request = new GetRequest.Builder()
                .index("test")
                .id("2")
                .build();
        GetResponse<Map> response = client.get(request, Map.class);
        System.out.println(response);
    }

    @Test
    public void testCreate() throws IOException {
        Map map = new ObjectMapper().readValue("{\"title\":\"戏赠大米手机\", \"images\":\"http://image.leyou.com/12479122.jpg\", \"price\":10000.0}", Map.class);
        CreateRequest request = new CreateRequest.Builder()
                .index("test")
                .id("12")
                .document(map)
                .build();
        CreateResponse response = client.create(request);
        System.out.println(response);
    }

//    @Test
//    public void testBulk() throws IOException {
//        List<Product> products = fetchProducts();
//
//        BulkRequest.Builder br = new BulkRequest.Builder();
//
//        for (Product product : products) {
//            br.operations(op -> op
//                    .index(idx -> idx
//                            .index("products")
//                            .id(product.getSku())
//                            .document(product)
//                    )
//            );
//        }
//
//        BulkResponse result = client.bulk(br.build());
//
//        // Log errors, if any
//        if (result.errors()) {
//            //logger.error("Bulk had errors");
//            for (BulkResponseItem item: result.items()) {
//                if (item.error() != null) {
//                    //logger.error(item.error().reason());
//                }
//            }
//        }
//    }

}
