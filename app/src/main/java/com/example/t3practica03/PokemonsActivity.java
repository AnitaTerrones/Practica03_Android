package com.example.t3practica03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.Intent;

import android.util.Log;
import android.view.View;

import com.example.t3practica03.adapters.PokemonAdapter;
import com.example.t3practica03.entities.Pokemons;
import com.example.t3practica03.services.PokemonService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class PokemonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemons);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/pokemons")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);
        Call<List<Pokemons>> pokemonCall =  service.getAll();
        pokemonCall.enqueue(new Callback<List<Pokemons>>() {
            @Override
            public void onResponse(Call<List<Pokemons>> call, Response<List<Pokemons>> response) {

                List<Pokemons> pokemons = response.body();
                RecyclerView rv = findViewById(R.id.rvLista);
                rv.setLayoutManager(new LinearLayoutManager(PokemonsActivity.this));
                PokemonAdapter adapter = new PokemonAdapter(pokemons);
                adapter.setOnclickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PokemonsActivity.this,DetalleActivity.class);
                        String pokemon = new Gson().toJson(pokemons.get(rv.getChildAdapterPosition(v)));
                        intent.putExtra("pokemon", pokemon);
                        startActivity(intent);
                    }
                });
                rv.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<Pokemons>> call, Throwable t) {
                Log.i("AIN_APP", "No hubo comunicacion con el servidor");
            }
        });
    }
    public List<String> GetDatos()
    {
        List<String> datos = new ArrayList<>();
        datos.add("urlImagen");
        datos.add("nombrePok");
        datos.add("tipoPok");
        return  datos;
    }

}