package com.cccc.pokemonkotlinspringbootrestapi.infrastructure.configuration

import com.cccc.pokemonkotlinspringbootrestapi.infrastructure.pokemon.repository.MemoryPokemonRepository
import com.cccc.pokemonkotlinspringbootrestapi.infrastructure.pokemon.mapper.PokemonMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PokemonConfiguration {
    
    @Bean
    fun pokemonRepository() = MemoryPokemonRepository()
    
    @Bean
    fun pokemonMapper() = PokemonMapper()
}