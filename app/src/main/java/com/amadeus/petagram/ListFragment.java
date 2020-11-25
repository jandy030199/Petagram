package com.amadeus.petagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    ArrayList mascotas;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listaMascotas = (RecyclerView) view.findViewById(R.id.rvMascotas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(linearLayoutManager);
        inicializarMascotas();
        inicializarAdapter();

        return view;
    }


    public void inicializarAdapter(){

        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascotas);
        listaMascotas.setAdapter(mascotaAdapter);
    }

    public void inicializarMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Catty",3,R.drawable.catty));
        mascotas.add(new Mascota("Doggy",2,R.drawable.doggy));
        mascotas.add(new Mascota("Foquisin",4,R.drawable.foquisin));
        mascotas.add(new Mascota("Rose",2,R.drawable.rose));
        mascotas.add(new Mascota("Spring",1,R.drawable.spring));
        mascotas.add(new Mascota("Orange",3,R.drawable.orange));
        mascotas.add(new Mascota("Sakura",2,R.drawable.sakura));
        mascotas.add(new Mascota("Shiro",4,R.drawable.shiro));
        mascotas.add(new Mascota("Sunshine",2,R.drawable.sunshine));
        mascotas.add(new Mascota("Violet",1,R.drawable.violet));

    }
}