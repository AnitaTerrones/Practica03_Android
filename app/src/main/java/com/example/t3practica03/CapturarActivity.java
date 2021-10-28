package com.example.t3practica03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.t3practica03.entities.Pokemons;
import com.example.t3practica03.services.PokemonService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CapturarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        EditText etNom = findViewById(R.id.etNombre);
        EditText etTip = findViewById(R.id.etTipo);
        EditText etImag = findViewById(R.id.etImagen);
        EditText etLat = findViewById(R.id.etLatitud);
        EditText etLong = findViewById(R.id.etlongitud);

        Button btnCrear = findViewById(R.id.tnCrearPokemon);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNom.getText().toString();
                String tipo = etTip.getText().toString();
                String imagen = etImag.getText().toString();
                String latitude = etLat.getText().toString();
                String longitude = etLong.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://upn.lumenes.tk/pokemons")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                PokemonService service = retrofit.create(PokemonService.class);
                Pokemons pokemons = new Pokemons();
                pokemons.setNombre(nombre);
                pokemons.setTipo(tipo);
                pokemons.setLatitude(latitude);
                pokemons.setLongitude(longitude);
                Call<Pokemons> call = service.create(pokemons);
                call.enqueue(new Callback<Pokemons>() {
                    @Override
                    public void onResponse(Call<Pokemons> call, Response<Pokemons> response) {
                    }
                    @Override
                    public void onFailure(Call<Pokemons> call, Throwable t) {

                    }
                });
            }
        });
    }
}