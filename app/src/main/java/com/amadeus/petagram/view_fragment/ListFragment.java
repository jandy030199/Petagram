package com.amadeus.petagram.view_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amadeus.petagram.adapter.MascotaAdapter;
import com.amadeus.petagram.R;
import com.amadeus.petagram.pojo.Mascota;
import com.amadeus.petagram.presenter.IListFragmentPresenter;
import com.amadeus.petagram.presenter.ListFragmentPresenter;

import java.util.ArrayList;


public class ListFragment extends Fragment implements IListFragmentView {


    private RecyclerView listaMascotas;
    private IListFragmentPresenter iListFragmentPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listaMascotas = (RecyclerView) view.findViewById(R.id.rvMascotas);

        iListFragmentPresenter = new ListFragmentPresenter(this,getContext());


        return view;
    }



    @Override
    public void generarLinearLayoutVetical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotaAdapter createAdapter(ArrayList<Mascota> mascotas) {
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascotas, getActivity());
        return mascotaAdapter;
    }

    @Override
    public void inicializarAdapter(MascotaAdapter mascotaAdapter) {
        listaMascotas.setAdapter(mascotaAdapter);
    }
}