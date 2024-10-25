package dev.rodrigomuller.pokeapimiddleware.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbilityPokeApiDTO {
    private int slot;
    private boolean is_hidden;
    @JsonProperty("ability")
    private AbilityDetailsDTO details;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public boolean isIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(boolean is_hidden) {
        this.is_hidden = is_hidden;
    }

    public AbilityDetailsDTO getDetails() {
        return details;
    }

    public void setDetails(AbilityDetailsDTO details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "AbilityPokeApiDTO{" +
                "slot=" + slot +
                ", is_hidden=" + is_hidden +
                ", details=" + details +
                '}';
    }
}
