package com.practice.client.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import io.crnk.client.CrnkClient;
import io.crnk.spring.client.RestTemplateAdapter;
import okhttp3.OkHttpClient;

/**
 * @author nrmaridu
 * @since May 18, 2020
 */
@Configuration
public class CrnkClientConfiguration {


    @Bean
    public RestTemplate restTemplate() {

        ClientHttpRequestFactory clientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory(new OkHttpClient());

        return new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(3000))
            .setReadTimeout(Duration.ofMillis(3000))
            .detectRequestFactory(false)
            .requestFactory(OkHttp3ClientHttpRequestFactory.class)
            .build();
    }

    @Bean
    public CrnkClient crnkClient(RestTemplate restTemplate) {
        CrnkClient crnkClient = new CrnkClient("http://localhost:8082/api");
        RestTemplateAdapter restTemplateAdapter = new RestTemplateAdapter(restTemplate);
        restTemplateAdapter.addListener(new AdapterListener());
        crnkClient.setHttpAdapter(restTemplateAdapter);
        return crnkClient;
    }


}
