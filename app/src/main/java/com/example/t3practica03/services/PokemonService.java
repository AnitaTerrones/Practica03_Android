package com.example.t3practica03.services;

import com.example.t3practica03.entities.Pokemons;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PokemonService {
    @GET("N00038907")
    Call<List<Pokemons>> getAll();

    @POST("N00038907/crear")
    Call<Pokemons> create(@Body Pokemons pokemons);
}
