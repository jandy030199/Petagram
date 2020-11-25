package com.amadeus.petagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {

    private  RecyclerView rvFotos;
    ArrayList mascotasFotos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        rvFotos = (RecyclerView) view.findViewById(R.id.rvFotos);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);

        rvFotos.setLayoutManager(gridLayoutManager);
        inicializarMascotas();
        inicializarAdapter();

        return view;
    }

    public void inicializarMascotas(){

        mascotasFotos = new ArrayList<Mascota>();

        mascotasFotos.add(new Mascota("Rose",3,R.drawable.rose));
        mascotasFotos.add(new Mascota("Rose",2,R.drawable.rose));
        mascotasFotos.add(new Mascota("Rose",4,R.drawable.rose));
        mascotasFotos.add(new Mascota("Rose",2,R.drawable.rose));
        mascotasFotos.add(new Mascota("Rose",1,R.drawable.rose));
        mascotasFotos.add(new Mascota("Rose",3,R.drawable.rose));
        mascotasFotos.add(new Mascota("Rose",2,R.drawable.rose));
        mascotasFotos.add(new Mascota("Rose",4,R.drawable.rose));
        mascotasFotos.add(new Mascota("Rose",2,R.drawable.rose));


    }

    public void inicializarAdapter(){

        ProfilePetAdapter profilePetAdapter = new ProfilePetAdapter(mascotasFotos);
        rvFotos.setAdapter(profilePetAdapter);
    }
}