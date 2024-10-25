package dev.rodrigomuller.pokeapimiddleware.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class PokeApiRestClientConfig {
    @Bean
    public RestClient restClient() {
        return RestClient.create();
    }
}
