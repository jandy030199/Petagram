package com.amadeus.petagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amadeus.petagram.R;
import com.amadeus.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ProfilePetAdapter extends RecyclerView.Adapter<ProfilePetAdapter.ProfilePetAdapterViewHolder> {

    private ArrayList<Mascota> mascotaLikes;

    public ProfilePetAdapter(ArrayList<Mascota> mascotaLikes) {
        this.mascotaLikes = mascotaLikes;
    }

    @NonNull
    @Override
    public ProfilePetAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_card_view,parent,false);
        return new ProfilePetAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfilePetAdapterViewHolder holder, int position) {

        Mascota mascota = mascotaLikes.get(position);
        holder.ivFotos.setImageResource(mascota.getFoto());
        holder.tvLikes.setText(String.valueOf(mascota.getNroLikes()));

    }

    @Override
    public int getItemCount() {
        return mascotaLikes.size();
    }

    public static class ProfilePetAdapterViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFotos;
        private TextView tvLikes;


        public ProfilePetAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFotos = (ImageView) itemView.findViewById(R.id.ivFotos);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }
}
