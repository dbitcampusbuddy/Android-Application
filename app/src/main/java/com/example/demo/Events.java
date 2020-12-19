package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Events extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[], s2[], s3[];
    int images[]={R.drawable.csi_logo,R.drawable.acm_logo,R.drawable.csi_logo,R.drawable.dbitlogo};
    int poster[] = {R.drawable.goc,R.drawable.teknack,R.drawable.hackathon,R.drawable.innovex};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        recyclerView = findViewById(R.id.recycler_events);

        s1 = getResources().getStringArray(R.array.Events);
        s2=getResources().getStringArray(R.array.organizer);
        s3=getResources().getStringArray(R.array.desc);


        EventAdapter eventAdapter = new EventAdapter(this, s1, s2, s3, images, poster);
        recyclerView.setAdapter(eventAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.events);

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
                        return true;

                    case R.id.placements:
                        startActivity(new Intent(getApplicationContext(),Placements.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }

        });

        
    }

}