package com.cccc.pokemonkotlinspringbootrestapi.infrastructure.pokemon.controller

import com.cccc.pokemonkotlinspringbootrestapi.domain.pokemon.model.Pokemon
import com.cccc.pokemonkotlinspringbootrestapi.domain.pokemon.repository.PokemonRepository
import com.cccc.pokemonkotlinspringbootrestapi.infrastructure.pokemon.mapper.PokemonMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pokemon")
class PokemonController(
    @Autowired private val pokemonRepository: PokemonRepository,
    @Autowired private val pokemonMapper: PokemonMapper
) {
    
    @GetMapping(value = ["/{name}"], produces = [APPLICATION_JSON_VALUE])
    fun getPokemon(@PathVariable("name") name: String): ResponseEntity<PokemonDto> =
        pokemonRepository
            .get(name)
            .let {
                ResponseEntity.ok(pokemonMapper.map(it))
            }
    
    @PostMapping(consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun createPokemon(
        @RequestBody pokemonDto: PokemonDto
    ): ResponseEntity<Pokemon> =
        pokemonMapper.map(pokemonDto)
            .let {
                ResponseEntity
                    .status(CREATED)
                    .body(pokemonRepository.create(it))
            }
    
    @PutMapping(value = ["/{name}"], consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun updatePokemon(
        @PathVariable("name") name: String, @RequestBody pokemonDto: PokemonDto
    ): ResponseEntity<PokemonDto> =
        pokemonMapper
            .map(pokemonDto)
            .apply {
                pokemonRepository
                    .update(this)
            }
            .let {
                ResponseEntity.ok(pokemonMapper.map(it))
            }
    
    @DeleteMapping(value = ["/{name}"])
    fun deletePokemon(@PathVariable("name") name: String): ResponseEntity<PokemonDto> =
        pokemonRepository.delete(name)
            .let {
                ResponseEntity.ok(pokemonMapper.map(it))
            }
    
    @ExceptionHandler(PokemonNotFoundException::class)
    fun handlePokemonNotFoundException() = ResponseEntity.notFound()
}