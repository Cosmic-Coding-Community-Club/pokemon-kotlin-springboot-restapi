package com.cccc.pokemonkotlinspringbootrestapi.domain.pokemon.repository

import com.cccc.pokemonkotlinspringbootrestapi.domain.pokemon.model.Pokemon


interface PokemonRepository {
    
    fun get(name : String): Pokemon
    fun create(pokemon: Pokemon): Pokemon
    fun update(pokemon: Pokemon): Pokemon
    fun delete(name: String) : Pokemon
}