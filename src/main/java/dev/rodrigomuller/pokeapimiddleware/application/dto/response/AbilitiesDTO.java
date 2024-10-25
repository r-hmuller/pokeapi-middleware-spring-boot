package dev.rodrigomuller.pokeapimiddleware.application.dto.response;

import java.util.ArrayList;
import java.util.List;

public class AbilitiesDTO {
    public List<String> names = new ArrayList<>();

    public AbilitiesDTO() {

    }

    public AbilitiesDTO(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void addName(String name) {
        getNames().add(name);
    }
}
