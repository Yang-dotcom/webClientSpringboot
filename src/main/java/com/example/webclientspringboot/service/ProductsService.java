package com.example.webclientspringboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 *  Service class that handles the business logic of a springboot application
 * @author dingyang.chen
 * @version 1.0
 * @since 2024-05-08
 */

@Slf4j
@Service
public class ProductsService {
    @Autowired
    private final WebClient webClient;

    public ProductsService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Map<String, Object>> getLimitSkipProducts(
            Integer limit,
            Integer skip,
            String select
    ){
        log.info("getLimitSkipProducts executed with parameters {} {} {}",
                limit, skip, select);
        return webClient.get().uri(uriBuilder -> uriBuilder
                        .path("/products")
                        .queryParam("limit", limit)
                        .queryParam("skip", skip)
                        .queryParam("select", select)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {});
    }


}
