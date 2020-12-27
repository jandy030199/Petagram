package com.amadeus.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.amadeus.petagram.adapter.MascotaAdapter;
import com.amadeus.petagram.pojo.Mascota;
import com.amadeus.petagram.presenter.FiveActivityPresenter;
import com.amadeus.petagram.presenter.IFiveActivityPresenter;
import com.amadeus.petagram.view_fragment.IFiveActivityView;

import java.util.ArrayList;

public class FiveActivity extends AppCompatActivity implements IFiveActivityView {

    private RecyclerView myFiveList;
    ArrayList mascotasFive;
    private FiveActivityPresenter fiveActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myFiveList = (RecyclerView) findViewById(R.id.rvFiveMascotas);

        fiveActivityPresenter = new FiveActivityPresenter(this, getBaseContext());


        }


    @Override
    public void generarLinearLayoutVetical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        myFiveList.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotaAdapter createAdapter(ArrayList<Mascota> mascotasFive) {
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascotasFive,this);
        return mascotaAdapter;

    }

    @Override
    public void inicializarAdapter(MascotaAdapter mascotaAdapter) {
        myFiveList.setAdapter(mascotaAdapter);

    }
}