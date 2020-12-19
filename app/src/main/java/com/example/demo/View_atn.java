package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class View_atn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_atn);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.attendance);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.attendance:
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
                        startActivity(new Intent(getApplicationContext(),Placements.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }

        });

    }
}