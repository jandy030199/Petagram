package com.amadeus.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FiveActivity extends AppCompatActivity {

    private RecyclerView myFiveList;
    ArrayList mascotasFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myFiveList = (RecyclerView) findViewById(R.id.rvFiveMascotas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        myFiveList.setLayoutManager(linearLayoutManager);
        inicializarFiveMascotas();
        inicializarAdapter();

    }

    public void inicializarAdapter(){

        MascotaAdapter adapter = new MascotaAdapter(mascotasFive);
        myFiveList.setAdapter(adapter);
    }

    public void inicializarFiveMascotas(){

        mascotasFive = new ArrayList<Mascota>();

        mascotasFive.add(new Mascota("Foquisin",4,R.drawable.foquisin));
        mascotasFive.add(new Mascota("Orange",3,R.drawable.orange));
        mascotasFive.add(new Mascota("Shiro",4,R.drawable.shiro));
        mascotasFive.add(new Mascota("Rose",2,R.drawable.rose));
        mascotasFive.add(new Mascota("Sunshine",2,R.drawable.sunshine));

    }


}