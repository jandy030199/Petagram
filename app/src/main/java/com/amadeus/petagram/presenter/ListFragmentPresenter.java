package com.amadeus.petagram.presenter;

import android.content.Context;

import com.amadeus.petagram.db.ConstructorMascotas;
import com.amadeus.petagram.pojo.Mascota;
import com.amadeus.petagram.view_fragment.IListFragmentView;

import java.util.ArrayList;

public class ListFragmentPresenter implements IListFragmentPresenter {

    private IListFragmentView iListFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public ListFragmentPresenter(IListFragmentView iListFragmentView, Context context) {

        this.iListFragmentView = iListFragmentView;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {

        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();

        mostrarMascotas();

    }

    @Override
    public void mostrarMascotas() {

        iListFragmentView.inicializarAdapter(iListFragmentView.createAdapter(mascotas));
        iListFragmentView.generarLinearLayoutVetical();

    }
}
