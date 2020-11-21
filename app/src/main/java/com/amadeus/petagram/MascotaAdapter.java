package com.amadeus.petagram;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    public MascotaAdapter(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    ArrayList<Mascota> mascotas;
    boolean myLike = true;


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
        holder.tvNroLikes.setText(String.valueOf(mascota.getNroLikes()));


        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              if(myLike == true){
                  holder.tvNroLikes.setText(String.valueOf(mascota.getNroLikes()+1));
                  holder.btnLike.setImageResource(R.drawable.bone_color);
                  myLike = false;
              }

              else {
                  holder.tvNroLikes.setText(String.valueOf(mascota.getNroLikes()));
                  holder.btnLike.setImageResource(R.drawable.bone);
                  myLike = true;
              }

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
        private ImageView btnLike;

        public MascotaViewHolder( View itemView) {
            super(itemView);
            ivFoto      = (ImageView) itemView.findViewById(R.id.ivFoto);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvNombre);
            tvNroLikes  = (TextView) itemView.findViewById(R.id.tvNroLikes);
            btnLike      = (ImageView) itemView.findViewById(R.id.btnLike);

        }
    }
}
