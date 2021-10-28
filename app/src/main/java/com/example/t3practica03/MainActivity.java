package com.example.t3practica03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.t3practica03.adapters.PokemonAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btnPokemons);
        Button button2 = findViewById(R.id.btnCapturar);

        //voy a pokemons activity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MAIN_APP", "Lista de pokemons");
                Intent intent = new Intent(getApplicationContext(), PokemonsActivity.class);
                startActivity(intent);
            }
        });

        //voy a capturar activity
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MAIN_APP", "Captura o registro de pokemons");
                Intent intent = new Intent(getApplicationContext(), CapturarActivity.class);
                startActivity(intent);
            }
        });

    }
}