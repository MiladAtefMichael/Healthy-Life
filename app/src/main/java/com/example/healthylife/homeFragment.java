package com.example.healthylife;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.healthylife.homeFragment;

import java.util.ArrayList;
import java.util.logging.Handler;


/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {

    RecyclerView recyclerView;
  private  itemsAdapter itemAdapter;
  private  RelativeLayout heart;
 private   RelativeLayout pressure;
 private    RelativeLayout excercise;
 private   RelativeLayout sleep;




    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View root=inflater.inflate(R.layout.fragment_home, container, false);
        if (container != null) {
            container.removeAllViews();
        }


       ArrayList<data> mydata=new ArrayList<data>();
        mydata.add(new data("do more exercise in this dy"));
        mydata.add(new data("sleep more for your heart health"));
        mydata.add(new data("enjoy this day"));
        mydata.add(new data("do more exercise in this dy"));
        mydata.add(new data("sleep more for your heart health"));
        mydata.add(new data("enjoy this day"));
        mydata.add(new data("do more exercise in this dy"));
        mydata.add(new data("sleep more for your heart health"));
        mydata.add(new data("enjoy this day"));
        mydata.add(new data("do more exercise in this dy"));
        mydata.add(new data("sleep more for your heart health"));
        mydata.add(new data("enjoy this day"));
        mydata.add(new data("do more exercise in this dy"));
        mydata.add(new data("sleep more for your heart health"));
        mydata.add(new data("enjoy this day"));
        mydata.add(new data("do more exercise in this dy"));
        mydata.add(new data("sleep more for your heart health"));
        mydata.add(new data("enjoy this day"));
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.rv);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        itemAdapter=new itemsAdapter(mydata);
        ////////////////////////////////////////////////////////////////////////////////////////////
        recyclerView.setAdapter(itemAdapter);
        /////////////////////////////////////////////////////////////////////
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //heart icon click action
       heart=(RelativeLayout) root.findViewById(R.id.heart);
       pressure=root.findViewById(R.id.pressure);
       excercise=root.findViewById(R.id.exercise);
        sleep=root.findViewById(R.id.sleep);
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),heartRate.class);
                startActivity(intent);
            }
        });
        pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),pressure.class);
                startActivity(intent);
            }
        });
        excercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),burnCalories.class);
                startActivity(intent);
            }
        });
        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),sleep.class);
                startActivity(intent);
            }
        });

        return root;
    }



}
