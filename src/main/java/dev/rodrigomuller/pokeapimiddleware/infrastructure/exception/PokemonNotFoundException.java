package dev.rodrigomuller.pokeapimiddleware.infrastructure.exception;

public class PokemonNotFoundException extends RuntimeException {

    public PokemonNotFoundException(String pokemon) {
        super("Pokemon " + pokemon + " not found");
    }
}