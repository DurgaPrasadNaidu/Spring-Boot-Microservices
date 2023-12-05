package com.dailycodebuffer.OrderService.Config;

import com.dailycodebuffer.OrderService.External.Decoder.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder decoder(){
        return new CustomErrorDecoder();
    }
}
