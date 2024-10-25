package dev.rodrigomuller.pokeapimiddleware.domain.service;

import dev.rodrigomuller.pokeapimiddleware.application.dto.response.AbilitiesDTO;
import dev.rodrigomuller.pokeapimiddleware.infrastructure.dto.AbilityPokeApiDTO;
import dev.rodrigomuller.pokeapimiddleware.infrastructure.dto.AbilityDetailsDTO;
import dev.rodrigomuller.pokeapimiddleware.infrastructure.service.PokeApiConnector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AbilityServiceTest {

    @Mock
    private PokeApiConnector pokeApiConnector;

    @InjectMocks
    private AbilityService abilityService;

    @Test
    public void testGetAbilitiesByPokemon() {
        // Arrange
        String pokemon = "charmander";
        List<AbilityPokeApiDTO> mockAbilities = Arrays.asList(
                new AbilityPokeApiDTO(0, true, new AbilityDetailsDTO("blaze", "http://pokeapi.co/api/v2/ability/66/")),
                new AbilityPokeApiDTO(1, false, new AbilityDetailsDTO("solar-power", "http://pokeapi.co/api/v2/ability/94/"))
        );

        when(pokeApiConnector.getAbilities(pokemon)).thenReturn(mockAbilities);

        AbilitiesDTO abilitiesDTO = abilityService.getAbilitiesByPokemon(pokemon);

        assertEquals(2, abilitiesDTO.getNames().size());
        assertEquals("blaze", abilitiesDTO.getNames().get(0));
        assertEquals("solar-power", abilitiesDTO.getNames().get(1));
    }
}