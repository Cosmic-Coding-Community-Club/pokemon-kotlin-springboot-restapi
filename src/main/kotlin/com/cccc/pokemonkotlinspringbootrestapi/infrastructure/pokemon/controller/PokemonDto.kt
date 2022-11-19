package com.cccc.pokemonkotlinspringbootrestapi.infrastructure.pokemon.controller

data class PokemonDto(
    val name: String,
    val attack: Int,
    val defense: Int,
    val speed: Int
)
