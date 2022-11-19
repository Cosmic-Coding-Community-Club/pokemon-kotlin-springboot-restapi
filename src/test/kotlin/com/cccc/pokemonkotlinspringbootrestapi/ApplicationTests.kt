package com.cccc.pokemonkotlinspringbootrestapi

import com.cccc.pokemonkotlinspringbootrestapi.domain.pokemon.model.Pokemon
import com.cccc.pokemonkotlinspringbootrestapi.domain.pokemon.repository.PokemonRepository
import com.cccc.pokemonkotlinspringbootrestapi.infrastructure.pokemon.controller.PokemonController
import com.cccc.pokemonkotlinspringbootrestapi.infrastructure.pokemon.controller.PokemonDto
import com.cccc.pokemonkotlinspringbootrestapi.infrastructure.pokemon.mapper.PokemonMapper
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(PokemonController::class)
class ApplicationTests {
    
    companion object {
        const val GIVEN_POKEMON_NAME = "pikachu"
    }
    
    @Autowired
    lateinit var mockMvc: MockMvc
    
    @MockkBean
    lateinit var repository: PokemonRepository
    
    @MockkBean
    lateinit var mapper: PokemonMapper
    
    private val objectMapper = ObjectMapper()
    
    @BeforeEach
    internal fun setUp() {
        every { repository.get(any()) } returns dummyPokemon()
        every { repository.create(any()) } returns dummyPokemon()
        every { repository.update(any()) } returns dummyPokemon()
        every { repository.delete(any()) } returns dummyPokemon()
        every { mapper.map(any<Pokemon>()) } returns dummyPokemonDto()
        every { mapper.map(any<PokemonDto>()) } returns dummyPokemon()
    }
    
    @Test
    fun shouldReturnOkStatusAndBodyWhenPerformGet() {
        mockMvc
            .perform(get("/pokemon/$GIVEN_POKEMON_NAME"))
            .andExpect(status().isOk)
            .andExpect {
                content()
                    .string(ObjectMapper().writeValueAsString(dummyPokemonDto()))
            }
    }
    
    @Test
    fun shouldReturnCreateStatusAndBodyWhenPerformPost() {
        mockMvc
            .perform(
                post("/pokemon")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(dummyPokemonDto()))
            )
            .andExpect(status().isCreated)
            .andExpect {
                content()
                    .string(objectMapper.writeValueAsString(dummyPokemonDto()))
            }
    }
    
    @Test
    fun shouldReturnOkStatusAndBodyWhenPerformPut() {
        mockMvc
            .perform(
                put("/pokemon/$GIVEN_POKEMON_NAME")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(dummyPokemonDto()))
            )
            .andExpect(status().isOk)
            .andExpect {
                content()
                    .string(objectMapper.writeValueAsString(dummyPokemonDto()))
            }
    }
    
    @Test
    fun shouldReturnOkStatusAndBodyWhenPerformDelete() {
        mockMvc
            .perform(delete("/pokemon/$GIVEN_POKEMON_NAME"))
            .andExpect(status().isOk)
            .andExpect {
                content()
                    .string(objectMapper.writeValueAsString(dummyPokemonDto()))
            }
    }
    
    private fun dummyPokemon() = Pokemon(GIVEN_POKEMON_NAME, 5, 20, 31)
    
    private fun dummyPokemonDto() = PokemonDto(GIVEN_POKEMON_NAME, 5, 20, 31)
}