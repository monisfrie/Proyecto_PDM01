package com.example.proyecto_pdm01.adaptadores;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_pdm01.R;
import com.example.proyecto_pdm01.modelos.Videojuego;

import java.util.ArrayList;

public class VideojuegoAdapter extends RecyclerView.Adapter<VideojuegoAdapter.ViewHolder>  {
    private ArrayList<Videojuego> videojuegos;

    public VideojuegoAdapter(ArrayList<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_videojuego, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Videojuego videojuego = videojuegos.get(position);
        holder.imagen.setImageResource(videojuego.imagen);
        holder.nombre.setText(videojuego.nombre);
        holder.descripcion.setText(videojuego.descripcion);
        holder.precio.setText(String.valueOf(videojuego.precio));
        holder.plataforma.setText(videojuego.plataforma);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = LayoutInflater.from(v.getContext());
                View dialogView = inflater.inflate(R.layout.dialog_detalle_videojuego, null);
                builder.setView(dialogView);
                AlertDialog dialog = builder.create();
                dialog.show();

                ImageView imagenDetalle = dialogView.findViewById(R.id.imagen_detalle);
                TextView nombreDetalle = dialogView.findViewById(R.id.nombre_detalle);
                TextView descripcionDetalle = dialogView.findViewById(R.id.descripcion_detalle);
                TextView precioDetalle = dialogView.findViewById(R.id.precio_detalle);
                TextView plataformaDetalle = dialogView.findViewById(R.id.plataforma_detalle);

                imagenDetalle.setImageResource(videojuego.imagen);
                nombreDetalle.setText(videojuego.nombre);
                descripcionDetalle.setText(videojuego.descripcion);
                precioDetalle.setText(String.valueOf(videojuego.precio));
                plataformaDetalle.setText(videojuego.plataforma);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = holder.getAdapterPosition();
                new AlertDialog.Builder(v.getContext())
                        .setTitle("Eliminar videojuego")
                        .setMessage("¿Estás seguro de que quieres eliminar este videojuego?")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                videojuegos.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("Cancelar", null)
                        .show();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return videojuegos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;
        public TextView descripcion;
        public TextView precio;
        public TextView plataforma;

        public ViewHolder(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_videojuego);
            nombre = itemView.findViewById(R.id.nombre_videojuego);
            descripcion = itemView.findViewById(R.id.descripcion_videojuego);
            precio = itemView.findViewById(R.id.precio_videojuego);
            plataforma = itemView.findViewById(R.id.plataforma_videojuego);
        }
    }
}
