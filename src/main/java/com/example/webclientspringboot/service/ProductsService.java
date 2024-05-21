package com.example.webclientspringboot.service;

import com.example.webclientspringboot.model.Product;
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


    public Mono<Product> postProduct(Product requestBody) {
        return webClient.post()
                .uri("/products/add")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Product.class);

    }

    /**
     * When you receive a Map<String, Object> from a method like getExternalData, you are essentially
     * dealing with a dynamic JSON structure that can change based on the parameters of the GET call.
     * Here's how you can work with such dynamic fields in Java:
     *
     * Example: Accessing Dynamic Fields
     * Suppose you have a Map<String, Object> returned by getExternalData, and the structure of the
     * JSON can vary. Here’s how you can access and manipulate the fields:
     *
     * Direct Access:
     * You can directly access the fields using the keys. Since the structure can vary, you should
     * perform checks to ensure the keys exist and the types are as expected.
     *
     * Iteration:
     * If you don't know the keys in advance, you can iterate over the entries of the map.
     *
     *
     * @param id
     * @param requestBody
     * @return
     */

    public Mono<Map<String, Object>> updateProduct(int id, Map<String, Object> requestBody) {
        return webClient.put()
                .uri("/products/{id}", id)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {});

    }

    public Mono<Map<String, Object>> deleteProduct(int id) {
        return webClient.delete()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {});

    }



}
