package com.ecommerce.ClientUI.configurations;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

@Configuration
public class FeignConfig {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user", "pwd");
    }
}
