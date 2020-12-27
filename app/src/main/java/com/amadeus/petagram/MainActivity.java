package com.amadeus.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.amadeus.petagram.adapter.PageAdapter;
import com.amadeus.petagram.view_fragment.ListFragment;
import com.amadeus.petagram.view_fragment.ProfileFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private TabLayout myTabLayout;
    private ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);


        myTabLayout = (TabLayout) findViewById(R.id.myTabLayout);
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);

        setUpViewPager();



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
            case R.id.mContact:
               Intent contactIntent = new Intent(this, ContactActivity.class);
               startActivity(contactIntent);
               break;
            case R.id.mAbout:
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new ListFragment());
        fragments.add(new ProfileFragment());

        return fragments;

    }

    private void setUpViewPager(){

        myViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.POSITION_NONE,agregarFragments()));
        myTabLayout.setupWithViewPager(myViewPager);
        setupTabIcons();



    }

    private void setupTabIcons() {
        myTabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        myTabLayout.getTabAt(1).setIcon(R.drawable.ic_pet_profile);
    }
}