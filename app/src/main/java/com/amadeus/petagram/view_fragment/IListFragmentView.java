package com.amadeus.petagram.view_fragment;

import com.amadeus.petagram.adapter.MascotaAdapter;
import com.amadeus.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IListFragmentView {

    public void generarLinearLayoutVetical();

    public MascotaAdapter createAdapter(ArrayList<Mascota> mascotas);

    public void inicializarAdapter(MascotaAdapter mascota);

}
