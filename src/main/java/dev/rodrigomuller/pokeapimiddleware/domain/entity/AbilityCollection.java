package dev.rodrigomuller.pokeapimiddleware.domain.entity;

import java.util.List;

public class AbilityCollection {
    // Criar collection de ability
    public List<Ability> abilities;

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public void addAbility(Ability ability) {
        getAbilities().add(ability);
    }
}
