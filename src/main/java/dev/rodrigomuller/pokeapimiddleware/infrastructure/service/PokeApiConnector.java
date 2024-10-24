package dev.rodrigomuller.pokeapimiddleware.infrastructure.service;

import dev.rodrigomuller.pokeapimiddleware.domain.entity.AbilityCollection;
import dev.rodrigomuller.pokeapimiddleware.infrastructure.dto.AbilityPokeApiDTO;
import dev.rodrigomuller.pokeapimiddleware.infrastructure.dto.PokemonPokeApiDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokeApiConnector {

    @Value("${pokeapi.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;
    public PokeApiConnector(
            RestTemplateBuilder restTemplateBuilder
    ) {
         this.restTemplate = restTemplateBuilder.build();
    }

    //TODO: Talvez mudar de string para um DTO Pokemon, já validado, que pode conter o nome
    public List<AbilityPokeApiDTO> getAbilities(String pokemon) {
        PokemonPokeApiDTO pokeApiDTO = this.getPokemonDetails(pokemon);
        return pokeApiDTO.getAbilities();
    }

    private PokemonPokeApiDTO getPokemonDetails(String pokemon) {
        String pokemonUrl = baseUrl + "/pokemon/" + pokemon;
        System.out.println(pokemonUrl);
        return this.restTemplate.getForObject(pokemonUrl, PokemonPokeApiDTO.class);
    }
}
