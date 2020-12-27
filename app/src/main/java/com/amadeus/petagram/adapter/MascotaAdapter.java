package com.amadeus.petagram.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.amadeus.petagram.R;
import com.amadeus.petagram.db.ConstructorMascotas;
import com.amadeus.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;

    }





    @Override
    public MascotaViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card_view,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MascotaViewHolder holder, int position) {

        Mascota mascota = mascotas.get(position);
        holder.ivFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvNroLikes.setText(String.valueOf(mascota.getNroLikes() + " Likes"));


        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
              constructorMascotas.darLikeMascota(mascota);
              holder.tvNroLikes.setText(constructorMascotas.obtenerLikes(mascota) + " Likes");


            }
        });



    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView   ivFoto;
        private TextView    tvNombre;
        private  TextView   tvNroLikes;
        private ImageButton btnLike;

        public MascotaViewHolder( View itemView) {
            super(itemView);
            ivFoto      = (ImageView) itemView.findViewById(R.id.ivFoto);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvNombre);
            tvNroLikes  = (TextView) itemView.findViewById(R.id.tvNroLikes);
            btnLike      = (ImageButton) itemView.findViewById(R.id.btnLike);

        }
    }
}
