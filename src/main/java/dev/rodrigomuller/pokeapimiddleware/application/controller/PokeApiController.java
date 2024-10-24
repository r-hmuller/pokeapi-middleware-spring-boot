package dev.rodrigomuller.pokeapimiddleware.application.controller;

import dev.rodrigomuller.pokeapimiddleware.application.dto.response.AbilitiesDTO;
import dev.rodrigomuller.pokeapimiddleware.domain.entity.AbilityCollection;
import dev.rodrigomuller.pokeapimiddleware.domain.service.AbilityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/abilities")
public class PokeApiController {

    private final AbilityService abilityService;
    public PokeApiController(
        AbilityService abilityService
    ) {
        this.abilityService = abilityService;
    }

    // Aqui tenho um método GET para pegar as habilidades a partir de um pokemon
    // TODO: Validar se pokemon existe antes de enviar pro pokeapi?
    @GetMapping("/{pokemon}")
    public AbilitiesDTO getPokemonAbilities(@PathVariable(name = "pokemon") String pokemon) {
        return abilityService.getAbilitiesByPokemon(pokemon);
    }
}