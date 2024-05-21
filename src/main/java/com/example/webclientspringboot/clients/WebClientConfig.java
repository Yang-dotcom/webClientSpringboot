package com.example.webclientspringboot.clients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.http.HttpHeaders;

/**
 * Configuration - creates a WebClient
 *
 * @author Dingyang Chen
 */

@Slf4j
@Configuration
public class WebClientConfig {
    private final String userName = "kminchelle";
    private final String password = "0lelplR";

    @Bean
    public WebClient createWebClient() {
        log.info("Webclient called");
        return WebClient.builder().baseUrl("https://dummyjson.com")
                .build()
                ;
    }
}
