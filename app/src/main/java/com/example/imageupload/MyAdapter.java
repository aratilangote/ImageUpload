package com.example.imageupload;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Model> mylist;
    private Context context;

    public MyAdapter(Context context, ArrayList<Model> mylist){
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        Glide.with(context).load(mylist.get(position).getImageUri()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        public MyViewHolder(View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.post);
        }
    }
}
