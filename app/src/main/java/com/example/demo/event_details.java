package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class event_details extends AppCompatActivity {

    ImageView mainImageView,orgImageView;
    TextView title, description,organizer;

    String data1,data2,data3;
    int myImage,organizers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        orgImageView=findViewById(R.id.imageView_org);
        mainImageView=findViewById(R.id.imageView_poster);
        title = findViewById(R.id.textView_Event);
        description = findViewById(R.id.textView_EventDesc);
        organizer = findViewById(R.id.textView_Organizer);

        getData();
        setData();

    }

    private void getData(){
             if(getIntent().hasExtra("data1") && getIntent().hasExtra("data2")  && getIntent().hasExtra("data3") && getIntent().hasExtra("myImage") && getIntent().hasExtra("banner")){
                 data1 = getIntent().getStringExtra("data1");
                 data2 = getIntent().getStringExtra("data3");
                 data3 = getIntent().getStringExtra("data2");
                 myImage = getIntent().getIntExtra("myImage", 1);
                 organizers = getIntent().getIntExtra("banner", 1);
             }else {
                 Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
             }

    }

    private void setData(){
        title.setText(data1);
        description.setText(data2);
        organizer.setText(data3);
        mainImageView.setImageResource(organizers);
        orgImageView.setImageResource(myImage);
    }
}