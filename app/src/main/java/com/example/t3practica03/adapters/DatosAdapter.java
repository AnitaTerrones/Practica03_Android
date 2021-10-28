package com.example.t3practica03.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t3practica03.R;
import com.example.t3practica03.entities.Pokemons;

import java.util.List;


public class DatosAdapter extends  RecyclerView.Adapter<DatosAdapter.NameViewHolder> {

    List<String> datos;

    public DatosAdapter(List<String> datos) {

        this.datos = datos;
    }

    @Override
    public DatosAdapter.NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdatos,parent,false);
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DatosAdapter.NameViewHolder holder, int position) {
        View view = holder.itemView;
        TextView tvDatos = view.findViewById(R.id.tvDatos);
        String dato = datos.get(position);
        tvDatos.setText(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(View itemView) {
            super(itemView);
        }
    }
}
