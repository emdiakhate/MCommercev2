package com.ecommerce.zullserver.configuration;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SleuthConfig {


    public Sampler defaultSample(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
