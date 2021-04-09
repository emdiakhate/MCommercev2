package com.ecommerce.ClientUI.clientConfig;

import com.ecommerce.ClientUI.exception.ClientErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientErrorDecoderConfig {
    @Bean
   public ClientErrorDecoder mCleintErrorDecoder(){
        return new ClientErrorDecoder();
    }
}
