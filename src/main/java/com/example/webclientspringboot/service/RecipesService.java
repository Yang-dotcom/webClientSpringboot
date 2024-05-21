package com.example.webclientspringboot.service;

import com.example.webclientspringboot.model.MultipleRecipes;
import lombok.extern.slf4j.Slf4j;
import com.example.webclientspringboot.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RecipesService {
    private final WebClient webClient;

    @Autowired
    public RecipesService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Recipe> getRecipe(int id) {
        log.info("getRecipe() executed with id {}", id);
        return webClient.get().uri("/recipes/{id}", id)
                .retrieve()
                .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                        clientResponse -> handleErrorResponse(clientResponse.statusCode()))
                .bodyToMono(Recipe.class);
    }

    public Mono<MultipleRecipes> getAllRecipes() {
        log.info("getAllRecipes executed");
        return webClient.get().uri("/recipes")
                .retrieve()
                .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                        clientResponse -> handleErrorResponse(clientResponse.statusCode()))
                .bodyToMono(MultipleRecipes.class);
    }

    public Mono<MultipleRecipes> searchRecipes(String q) {
        log.info("searchRecipes executed with search key:{}",
                q);
        return webClient.get().uri(uriBuilder -> uriBuilder
                        .path("/recipes/search")
                        .queryParam("q", q)
                        .build())
                .retrieve()
                .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                        clientResponse -> handleErrorResponse(clientResponse.statusCode()))
                .bodyToMono(MultipleRecipes.class);
    }




    private Mono<? extends Throwable> handleErrorResponse(HttpStatusCode statusCode) {

        // Handle non-success status codes here (e.g., logging or custom error handling)
        return Mono.error(new RuntimeException("Method failed with code: "+ statusCode));
    }


}
