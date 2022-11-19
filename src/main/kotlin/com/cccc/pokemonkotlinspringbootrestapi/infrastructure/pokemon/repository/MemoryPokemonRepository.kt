package com.cccc.pokemonkotlinspringbootrestapi.infrastructure.pokemon.repository

import com.cccc.pokemonkotlinspringbootrestapi.domain.pokemon.model.Pokemon
import com.cccc.pokemonkotlinspringbootrestapi.domain.pokemon.repository.PokemonRepository
import com.cccc.pokemonkotlinspringbootrestapi.infrastructure.pokemon.controller.PokemonNotFoundException

class MemoryPokemonRepository : PokemonRepository {
    
    private val pokemons: MutableMap<String, Pokemon> = mutableMapOf()
    
    override fun get(name: String) =
        pokemons[name] ?: throw PokemonNotFoundException(name)
    
    override fun create(pokemon: Pokemon): Pokemon =
        pokemon.apply { pokemons[pokemon.name] = pokemon }
    
    
    override fun update(pokemon: Pokemon): Pokemon =
        pokemon.apply { pokemons[pokemon.name] = this }
    
    override fun delete(name: String): Pokemon =
        pokemons.remove(name) ?: throw PokemonNotFoundException(name)
}