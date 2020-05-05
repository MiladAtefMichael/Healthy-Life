package com.example.healthylife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class statusHistoyAdpater extends RecyclerView.Adapter<statusHistoyAdpater.itemHolder> {
       private ArrayList<statusHistoryData> listItems;


public statusHistoyAdpater(ArrayList<statusHistoryData> listItems) {
        this.listItems = listItems;

        }

@NonNull
@Override
public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.status_history_item,parent,false);
        itemHolder listHolder=new itemHolder(view);
        return listHolder;
        }

@Override
public void onBindViewHolder(@NonNull itemHolder holder, int position) {
    holder.dateTextView.setText(listItems.get(position).getDate());
    holder.heartRate.setText(listItems.get(position).getHaeartRate());
    holder.pressure.setText(listItems.get(position).getPressure());

        }


@Override
public int getItemCount() {
        return listItems.size();
        }


public class itemHolder extends RecyclerView.ViewHolder{
    TextView dateTextView;
    TextView heartRate;
    TextView pressure;


    public itemHolder(@NonNull View itemView) {
        super(itemView);
        dateTextView=itemView.findViewById(R.id.history_status_date);
        heartRate=itemView.findViewById(R.id.heart_status_text);
        pressure=itemView.findViewById(R.id.pressure_status_text);

    }
}
}

