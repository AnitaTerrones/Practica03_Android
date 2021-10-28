package com.example.t3practica03.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t3practica03.R;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t3practica03.entities.Pokemons;
import com.squareup.picasso.Picasso;

import java.util.List;


public class PokemonAdapter extends  RecyclerView.Adapter<PokemonAdapter.NameViewHolder>{

    private List<Pokemons> pokemons;
    private  View.OnClickListener listener;

    public PokemonAdapter(List<Pokemons> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itempokemon, parent, false);

        return new NameViewHolder(view);
    }
    @Override
    public void onBindViewHolder(PokemonAdapter.NameViewHolder holder, int position) {

        TextView tvnombre = holder.itemView.findViewById(R.id.tvNombreP);
        TextView tvtipo = holder.itemView.findViewById(R.id.tvTipoP);

        Pokemons pok = pokemons.get(position);

        tvnombre.setText(pok.nombre);
        tvtipo.setText(pok.tipo);

    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public void setOnclickListener(View.OnClickListener pokemon) {
    }


    class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(View itemView) {
            super(itemView);
        }
    }
}
