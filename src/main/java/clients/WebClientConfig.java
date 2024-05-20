package clients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration - creates a WebClient
 *
 * @author Dingyang Chen
 */

@Configuration
public class WebClientConfig {
    private final String userName = "kminchelle";
    private final String password = "0lelplR";

    @Bean
    public WebClient createWebClient() {
        return WebClient.builder().baseUrl("https://dummyjson.com/")
                .defaultHeaders(headers -> headers.setBasicAuth(userName,password))
                .build()
                ;
    }
}
