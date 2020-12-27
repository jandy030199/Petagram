package com.amadeus.petagram.presenter;

import android.content.Context;

import com.amadeus.petagram.adapter.MascotaAdapter;
import com.amadeus.petagram.db.ConstructorMascotas;
import com.amadeus.petagram.pojo.Mascota;
import com.amadeus.petagram.view_fragment.IFiveActivityView;
import com.amadeus.petagram.view_fragment.IListFragmentView;

import java.util.ArrayList;

public class FiveActivityPresenter implements IFiveActivityPresenter{

    private IFiveActivityView iFiveActivityView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotasFive;

    public FiveActivityPresenter(IFiveActivityView iFiveActivityView, Context context) {
        this.iFiveActivityView = iFiveActivityView;
        this.context = context;
        obtenerMascotasFive();
    }

    @Override
    public void obtenerMascotasFive() {

        constructorMascotas = new ConstructorMascotas(context);
        mascotasFive = constructorMascotas.obtenerDatosFive();

        mostrarMascotasFive();


    }

    @Override
    public void mostrarMascotasFive() {

        iFiveActivityView.inicializarAdapter(iFiveActivityView.createAdapter(mascotasFive));
        iFiveActivityView.generarLinearLayoutVetical();

    }
}
