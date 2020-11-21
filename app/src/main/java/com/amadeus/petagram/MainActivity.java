package com.amadeus.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(linearLayoutManager);
        inicializarMascotas();
        inicializarAdapter();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu_actionviews,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.viewFive:
                Intent intent = new Intent(this,FiveActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}