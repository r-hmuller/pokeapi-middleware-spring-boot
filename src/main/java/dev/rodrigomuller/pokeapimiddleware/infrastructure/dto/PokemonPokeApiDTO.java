package dev.rodrigomuller.pokeapimiddleware.infrastructure.dto;

import java.util.List;

public class PokemonPokeApiDTO {
    private int id;
    private String name;
    private List<AbilityPokeApiDTO> abilities;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AbilityPokeApiDTO> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityPokeApiDTO> abilities) {
        this.abilities = abilities;
    }
}
