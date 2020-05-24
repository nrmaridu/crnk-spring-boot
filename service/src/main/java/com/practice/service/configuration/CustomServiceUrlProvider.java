package com.practice.service.configuration;

import java.net.URI;
import java.net.URL;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;

import io.crnk.core.engine.http.HttpRequestContext;
import io.crnk.core.engine.url.ServiceUrlProvider;
import io.crnk.core.module.ModuleRegistry;
import lombok.SneakyThrows;

/**
 * @author nrmaridu
 * @since May 20, 2020
 */
//@Component
public class CustomServiceUrlProvider implements ServiceUrlProvider {

    private ModuleRegistry moduleRegistry;

    public CustomServiceUrlProvider(ModuleRegistry moduleRegistry) {
        this.moduleRegistry = moduleRegistry;
    }


    @SneakyThrows
    @Override
    public String getUrl() {
        HttpRequestContext requestContext = getRequestContext();

        URI uri = URI.create(requestContext.getQueryContext().getBaseUrl());

        URL url = uri.toURL();

        String finalUrl = null;



        if (url.getHost().toString().equals("localhost")) {
            finalUrl = new URIBuilder().setScheme(url.getProtocol())
                .setHost(url.getHost())
                .setPort(url.getPort())
                .setPathSegments(url.getPath())
                .build()
                .toString();
        } else {
            finalUrl = uri.toString();
        }

        return finalUrl;

    }

    private HttpRequestContext getRequestContext() {
        return this.moduleRegistry.getHttpRequestContextProvider().getRequestContext();
    }
}
