package com.practice.service.configuration;

import org.springframework.context.annotation.Configuration;

import io.crnk.core.boot.CrnkBoot;
import io.crnk.core.engine.url.ServiceUrlProvider;

/**
 * @author nrmaridu
 * @since May 20, 2020
 */
//@Configuration
public class ApplicationConfiguration {

    private CrnkBoot crnkBoot;

    private CustomServiceUrlProvider customServiceUrlProvider;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public ApplicationConfiguration(CrnkBoot crnkBoot, CustomServiceUrlProvider customServiceUrlProvider) {
        this.crnkBoot = crnkBoot;
        this.customServiceUrlProvider = customServiceUrlProvider;
        this.addServiceUrlProvider(crnkBoot, customServiceUrlProvider);
    }

    /**
     * Register custom service url provider with crnk Boot
     *
     * @param crnkBoot           {@link CrnkBoot}
     * @param serviceUrlProvider {@link CustomServiceUrlProvider}
     */
    private void addServiceUrlProvider(CrnkBoot crnkBoot, ServiceUrlProvider serviceUrlProvider) {
        crnkBoot.getModuleRegistry().getHttpRequestContextProvider().setServiceUrlProvider(serviceUrlProvider);
    }
}
