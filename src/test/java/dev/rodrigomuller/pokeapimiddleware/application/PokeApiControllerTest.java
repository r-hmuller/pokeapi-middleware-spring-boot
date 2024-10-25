package dev.rodrigomuller.pokeapimiddleware.application;

import dev.rodrigomuller.pokeapimiddleware.application.controller.PokeApiController;
import dev.rodrigomuller.pokeapimiddleware.application.dto.response.AbilitiesDTO;
import dev.rodrigomuller.pokeapimiddleware.domain.service.AbilityService;
import dev.rodrigomuller.pokeapimiddleware.infrastructure.exception.PokemonNotFoundException;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PokeApiController.class)
public class PokeApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AbilityService abilityService;

    @Test
    public void testGetAbilitiesWithValidPokemonShouldReturn200AndContainsAbilities() throws Exception {
        when(abilityService.getAbilitiesByPokemon("charmander")).thenReturn(getCharmanderAbilities());

        mockMvc.perform(get("/abilities/charmander")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"names\":[\"blaze\",\"solar-power\"]}"));
    }

    private AbilitiesDTO getCharmanderAbilities() {
        AbilitiesDTO abilitiesDTO = new AbilitiesDTO();
        abilitiesDTO.addName("blaze");
        abilitiesDTO.addName("solar-power");
        return abilitiesDTO;
    }

    @Test
    public void testGetAbilitiesWithInvalidPokemonShouldReturn404() throws Exception {
        when(abilityService.getAbilitiesByPokemon("poseidon")).thenThrow(new PokemonNotFoundException("poseidon"));

        mockMvc.perform(get("/abilities/poseidon")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}