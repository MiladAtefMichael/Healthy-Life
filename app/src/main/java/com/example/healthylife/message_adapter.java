package com.example.healthylife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class message_adapter extends RecyclerView.Adapter<message_adapter.messageHolder > {
    ArrayList<messageData> listItems;


    public message_adapter(ArrayList<messageData> listItems) {
        this.listItems = listItems;

    }

    @NonNull
    @Override
    public messageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.message,parent,false);
        messageHolder listHolder=new messageHolder(view);
        return listHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull messageHolder holder, int position) {
        holder.name.setText(listItems.get(position).getName());
        holder.message.setText(listItems.get(position).getMessage());

    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public class messageHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView message;

        public messageHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.message_name);
            message=itemView.findViewById(R.id.message);

        }
    }
}

