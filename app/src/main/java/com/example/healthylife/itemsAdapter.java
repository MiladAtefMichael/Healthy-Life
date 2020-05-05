package com.example.healthylife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class itemsAdapter extends RecyclerView.Adapter<itemsAdapter.itemHolder > {
    ArrayList<data> listItems;


    public itemsAdapter(ArrayList<data> listItems) {
        this.listItems = listItems;

    }

    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        itemHolder listHolder=new itemHolder(view);
        return listHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position) {
        holder.mTextView.setText(listItems.get(position).getItem());

    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public class itemHolder extends RecyclerView.ViewHolder{
        TextView mTextView;

        public itemHolder(@NonNull View itemView) {
            super(itemView);
            mTextView=itemView.findViewById(R.id.text);

        }
    }
}
