package com.example.demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    String data1[] , data2[],data3[];
    int images[],banner[];
    Context context;
    public EventAdapter(Context ct, String s1[], String s2[],String s3[], int img[] , int poster[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        data3= s3;
        images = img;
        banner = poster;

    }
    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.event_row, parent, false);
        return new EventViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, final int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
       // holder.myText3.setText(data3);
        holder.myImage.setImageResource(images[position]);

        holder.eventsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,event_details.class);
                intent.putExtra("data1",data1[position]);
                intent.putExtra("data2",data2[position]);
                intent.putExtra("data3",data3[position]);
                intent.putExtra("myImage",images[position]);
                intent.putExtra("banner",banner[position]);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2, myText3;
        ImageView myImage, myBanner;
        ConstraintLayout eventsLayout;
        public EventViewHolder(View itemView){
            super(itemView);
            myText1=itemView.findViewById(R.id.textView2);
            myText2=itemView.findViewById(R.id.textView1);
            myImage=itemView.findViewById(R.id.imageView);
            eventsLayout = itemView.findViewById(R.id.eventsLayout);
        }
    }
}
