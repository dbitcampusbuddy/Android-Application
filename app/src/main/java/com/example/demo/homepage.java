package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.demo.MainActivity.*;

public class homepage extends AppCompatActivity {



    // creating object of ViewPager
    ViewPager mViewPager;

    // images array
    int[] images = {R.drawable.goc, R.drawable.innovex, R.drawable.teknack, R.drawable.innovex,
            };

    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Intent intent = getIntent();
        final String id = intent.getStringExtra("username");

        Toast.makeText(homepage.this, id, Toast.LENGTH_LONG).show();

        // Initializing the ViewPager Object
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(homepage.this, images);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.attendance:
                        startActivity(new Intent(getApplicationContext(),View_atn.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.exam:
                        //startActivity(new Intent(getApplicationContext(),Examination.class));
                        Intent intent = new Intent(getApplicationContext(),Examination.class);
                        //String id = etEmail.getText().toString();
                        intent.putExtra("username",id);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
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