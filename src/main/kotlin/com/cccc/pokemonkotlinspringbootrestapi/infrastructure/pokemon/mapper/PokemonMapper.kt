package com.cccc.pokemonkotlinspringbootrestapi.infrastructure.pokemon.mapper

import com.cccc.pokemonkotlinspringbootrestapi.domain.pokemon.model.Pokemon
import com.cccc.pokemonkotlinspringbootrestapi.infrastructure.pokemon.controller.PokemonDto

class PokemonMapper {
    
    fun map(pokemonDto: PokemonDto) = with(pokemonDto) {
        Pokemon(name, attack, defense, speed)
    }
    
    fun map(pokemon: Pokemon) = with(pokemon) {
        PokemonDto(name, attack, defense, speed)
    }
}