package com.example.t3practica03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t3practica03.entities.Pokemons;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ImageView imagen = findViewById(R.id.tvImagenPokemon);
        TextView tvnombre = findViewById(R.id.tvNombrePokemon);
        TextView tvtipo = findViewById(R.id.tvTipoPokemon);

        Intent intent = getIntent();
        String pokemon = intent.getStringExtra("pokemon");
        Pokemons pokemons = new Gson().fromJson(pokemon,Pokemons.class);

        tvnombre.setText(pokemons.getNombre());
        tvtipo.setText(pokemons.getTipo());
    }
}