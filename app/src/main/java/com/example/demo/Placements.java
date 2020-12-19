package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Placements extends AppCompatActivity {


    RecyclerView recyclerView;
    String s1[], s2[];
    int images[]={R.drawable.lets,R.drawable.cg,R.drawable.xoriant,R.drawable.tcs};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placements);

        recyclerView = findViewById(R.id.placement_recycler);

        s1 = getResources().getStringArray(R.array.Company);
        s2=getResources().getStringArray(R.array.date);

        PlacementAdapter placementAdapter = new PlacementAdapter(this, s1, s2, images);
        recyclerView.setAdapter(placementAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.placement_filter_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Placements.this, placement_filter.class));
            }
        });*/

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.placements);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.attendance:
                        startActivity(new Intent(getApplicationContext(),View_atn.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.exam:
                        startActivity(new Intent(getApplicationContext(),Examination.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),homepage.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.events:
                        startActivity(new Intent(getApplicationContext(),Events.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.placements:
                        return true;
                }
                return false;
            }

        });

    }

}
