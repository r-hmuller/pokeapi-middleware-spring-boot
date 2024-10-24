package dev.rodrigomuller.pokeapimiddleware.infrastructure;

import dev.rodrigomuller.pokeapimiddleware.domain.entity.AbilityCollection;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiConnector {

    public PokeApiConnector(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder.build();
    }

    //TODO: Talvez mudar de string para um DTO Pokemon, já validado, que pode conter o nome
    public AbilityCollection getAbilities(String pokemon) {

        return new AbilityCollection();
    }
}
