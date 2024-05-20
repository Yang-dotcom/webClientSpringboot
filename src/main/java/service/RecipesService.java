package service;

import model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RecipesService {
    private final WebClient webClient;

    @Autowired
    public RecipesService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Recipe> getRecipe(int id) {
        return webClient.get().uri("/recipes/{id}", id)
                .retrieve()
                .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                        clientResponse -> handleErrorResponse(clientResponse.statusCode()))
                .bodyToMono(Recipe.class);
    }


    private Mono<? extends Throwable> handleErrorResponse(HttpStatusCode statusCode) {

        // Handle non-success status codes here (e.g., logging or custom error handling)
        return Mono.error(new RuntimeException("Method failed with code: "+ statusCode));
    }
}
