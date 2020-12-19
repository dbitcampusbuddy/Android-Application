package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlacementAdapter extends RecyclerView.Adapter<com.example.demo.PlacementAdapter.PlacementViewHolder>{

        String data1[] , data2[];
        int images[];
        Context context;
        public PlacementAdapter(Context ct, String s1[], String s2[], int img[] ){
            context = ct;
            data1 = s1;
            data2 = s2;
            images = img;
        }
        @NonNull
        @Override
        public com.example.demo.PlacementAdapter.PlacementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.event_row, parent, false);
            return new com.example.demo.PlacementAdapter.PlacementViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull com.example.demo.PlacementAdapter.PlacementViewHolder holder, int position) {
            holder.myText1.setText(data1[position]);
            holder.myText2.setText(data2[position]);
            holder.myImage.setImageResource(images[position]);
        }

        @Override
        public int getItemCount() {
            return images.length;
        }

        public class PlacementViewHolder extends RecyclerView.ViewHolder{

            TextView myText1, myText2;
            ImageView myImage;
            public PlacementViewHolder(View itemView){
                super(itemView);
                myText1=itemView.findViewById(R.id.textView2);
                myText2=itemView.findViewById(R.id.textView1);
                myImage=itemView.findViewById(R.id.imageView);

            }
        }
    }

