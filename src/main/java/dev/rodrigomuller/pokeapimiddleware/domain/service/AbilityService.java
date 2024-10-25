package dev.rodrigomuller.pokeapimiddleware.domain.service;

import dev.rodrigomuller.pokeapimiddleware.application.dto.response.AbilitiesDTO;
import dev.rodrigomuller.pokeapimiddleware.infrastructure.dto.AbilityPokeApiDTO;
import dev.rodrigomuller.pokeapimiddleware.infrastructure.service.PokeApiConnector;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityService {
    private final PokeApiConnector pokeApiConnector;

    public AbilityService(
        PokeApiConnector pokeApiConnector
    ) {
        this.pokeApiConnector = pokeApiConnector;
    }

    public AbilitiesDTO getAbilitiesByPokemon(String pokemon) {
        List<AbilityPokeApiDTO> pokeApiDTO = pokeApiConnector.getAbilities(pokemon);
        AbilitiesDTO abilitiesDTO = new AbilitiesDTO();

        pokeApiDTO.forEach(ability -> abilitiesDTO.addName(ability.getDetails().getName()));

        return abilitiesDTO;
    }
}
