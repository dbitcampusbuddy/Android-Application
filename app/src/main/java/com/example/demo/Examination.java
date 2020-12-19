package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class Examination extends AppCompatActivity {
    // DatabaseHelper myDb;

    private Button submit_button;
    private EditText sem_text;
    private EditText sub_text;


    private TextView ia1s1;
    private TextView ia2s1;
    private TextView ends1;
    private TextView ia1s2;
    private TextView ia2s2;
    private TextView ends2;
    private TextView ia1s3;
    private TextView ia2s3;
    private TextView ends3;
    private TextView ia1s4;
    private TextView ia2s4;
    private TextView ends4;
    private TextView ia1s5;
    private TextView ia2s5;
    private TextView ends5;
    private TextView CGPA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examination);

        Intent intent = getIntent();
        final String id = intent.getStringExtra("username");


        ia1s1 = (TextView) findViewById(R.id.txt_ia1_sub1);
        ia2s1 = (TextView) findViewById(R.id.txt_ia2_sub1);
        ends1 = (TextView) findViewById(R.id.txt_endsem_sub1);
        ia1s2 = (TextView) findViewById(R.id.txt_ia1_sub2);
        ia2s2 = (TextView) findViewById(R.id.txt_ia2_sub2);
        ends2 = (TextView) findViewById(R.id.txt_Endsem_sub2);
        ia1s3 = (TextView) findViewById(R.id.txt_ia1_sub3);
        ia2s3 = (TextView) findViewById(R.id.txt_ia2_sub3);
        ends3 = (TextView) findViewById(R.id.txt_endsem_sub3);
        ia1s4 = (TextView) findViewById(R.id.txt_ia1_sub4);
        ia2s4 = (TextView) findViewById(R.id.txt_ia2_sub4);
        ends4 = (TextView) findViewById(R.id.txt_endsem_sub4);
        ia1s5 = (TextView) findViewById(R.id.txt_ia1_sub5);
        ia2s5 = (TextView) findViewById(R.id.txt_ia2_sub5);
        ends5 = (TextView) findViewById(R.id.txt_endsem_sub5);
        CGPA = (TextView) findViewById(R.id.textcgpadisp);

        String url = config.DATA_URL + id.trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Examination.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        Button edit_btn = (Button) findViewById(R.id.button2);

        edit_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),Edit_Marks.class);
                //String id = etEmail.getText().toString();
                intent.putExtra("username",id);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.exam);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.attendance:
                        startActivity(new Intent(getApplicationContext(),View_atn.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.exam:
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

    private void showJSON(String response) {
        String ia1_s1 = "";
        String ia2_s1 = "";
        String end_s1 = "";
        String ia1_s2 = "";
        String ia2_s2 = "";
        String end_s2 = "";
        String ia1_s3 = "";
        String ia2_s3 = "";
        String end_s3 = "";
        String ia1_s4 = "";
        String ia2_s4 = "";
        String end_s4 = "";
        String ia1_s5 = "";
        String ia2_s5 = "";
        String end_s5 = "";
        String cgpa = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(config.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            ia1_s1 = collegeData.getString(config.KEY_ia1s1);
            ia2_s1 = collegeData.getString(config.KEY_ia2s1);
            end_s1 = collegeData.getString(config.KEY_ends1);
            ia1_s2 = collegeData.getString(config.KEY_ia1s2);
            ia2_s2 = collegeData.getString(config.KEY_ia2s2);
            end_s2 = collegeData.getString(config.KEY_ends2);
            ia1_s3 = collegeData.getString(config.KEY_ia1s3);
            ia2_s3 = collegeData.getString(config.KEY_ia2s3);
            end_s3 = collegeData.getString(config.KEY_ends3);
            ia1_s4 = collegeData.getString(config.KEY_ia1s4);
            ia2_s4 = collegeData.getString(config.KEY_ia2s4);
            end_s4 = collegeData.getString(config.KEY_ends4);
            ia1_s5 = collegeData.getString(config.KEY_ia1s5);
            ia2_s5 = collegeData.getString(config.KEY_ia2s5);
            end_s5 = collegeData.getString(config.KEY_ends5);
            cgpa = collegeData.getString(config.KEY_CGPA);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ia1s1.setText(ia1_s1);
        ia2s1.setText(ia2_s1);
        ends1.setText(end_s1);
        ia1s2.setText(ia1_s2);
        ia2s2.setText(ia2_s2);
        ends2.setText(end_s2);
        ia1s3.setText(ia1_s3);
        ia2s3.setText(ia2_s3);
        ends3.setText(end_s3);
        ia1s4.setText(ia1_s4);
        ia2s4.setText(ia2_s4);
        ends4.setText(end_s4);
        ia1s5.setText(ia1_s5);
        ia2s5.setText(ia2_s5);
        ends5.setText(end_s5);
        CGPA.setText(cgpa);

    }

}