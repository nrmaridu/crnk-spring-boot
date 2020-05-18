package com.practice.client.config;

import io.crnk.client.http.HttpAdapterListener;
import io.crnk.client.http.HttpAdapterRequest;
import io.crnk.client.http.HttpAdapterResponse;

/**
 * @author nrmaridu
 * @since May 19, 2020
 */
public class AdapterListener implements HttpAdapterListener {

    @Override
    public void onRequest(HttpAdapterRequest request) {
        System.out.println("Request intercepted");
    }

    @Override
    public void onResponse(HttpAdapterRequest request, HttpAdapterResponse response) {
        System.out.println("Response intercepted");
    }
}
