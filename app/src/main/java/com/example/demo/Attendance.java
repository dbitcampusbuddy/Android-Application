package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Attendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        //View Attendance Button
        Button view_btn = (Button) findViewById(R.id.view_atn_btn);

        view_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Attendance.this, View_atn.class));
            }
        });


        //Leave Application Button
        Button leave_app_btn = (Button) findViewById(R.id.leave_app_btn);

        leave_app_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Attendance.this, leave_application.class));
            }
        });

        //Bottom Nav Bar
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