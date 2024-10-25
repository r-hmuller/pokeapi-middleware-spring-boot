package dev.rodrigomuller.pokeapimiddleware.infrastructure.service;

import dev.rodrigomuller.pokeapimiddleware.domain.entity.AbilityCollection;
import dev.rodrigomuller.pokeapimiddleware.infrastructure.dto.AbilityPokeApiDTO;
import dev.rodrigomuller.pokeapimiddleware.infrastructure.dto.PokemonPokeApiDTO;
import dev.rodrigomuller.pokeapimiddleware.infrastructure.exception.PokemonNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class PokeApiConnector {

    private static final Logger log = LoggerFactory.getLogger(PokeApiConnector.class);
    @Value("${pokeapi.url}")
    private String baseUrl;

    private RestClient restClient;

    public PokeApiConnector(RestClient restClient) {
         this.restClient = RestClient.create();
    }

    public List<AbilityPokeApiDTO> getAbilities(String pokemon) {
        PokemonPokeApiDTO pokeApiDTO = this.getPokemonDetails(pokemon);
        return pokeApiDTO.getAbilities();
    }

    private PokemonPokeApiDTO getPokemonDetails(String pokemon) {
        String pokemonUrl = baseUrl + "/pokemon/" + pokemon;

        return this.restClient
                .get()
                .uri(URI.create(pokemonUrl))
                .retrieve()
                .onStatus(status -> status.value() == 404, (request, response) -> {
                    log.atInfo().log("Pokemon " + pokemon + " not found");
                    throw new PokemonNotFoundException(pokemon);
                })
                .body(PokemonPokeApiDTO.class);
    }
}
