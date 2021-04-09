package com.ecommerce.mproduit.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my-configs")
public class ApplicationPropertiesConfig {
    private int limitDeProduit;

    public int getLimitDeProduit() {
        return limitDeProduit;
    }

    public void setLimitDeProduit(int limitDeProduit) {
        this.limitDeProduit = limitDeProduit;
    }
}
