package com.example.healthylife;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class messageFragment extends Fragment {
message_adapter message_adapter;
    ArrayList<messageData> mData=new ArrayList<messageData>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER




    public messageFragment() { }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_message, container, false);
        if (container != null) {
            container.removeAllViews();
        }
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.message_rv);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        /////////////////////////
        mData.add(new messageData("Dr Ahmed Shokry","do more exercise in this day"));
        mData.add(new messageData("Dr abo 3mo","do more exercise in this dy"));
        mData.add(new messageData("melad","do more exercise in this dy"));
        mData.add(new messageData("Dr Ahmed Shokry","do more exercise in this dy"));
        mData.add(new messageData("Dr Ahmed Shokry","do more exercise in this dy"));
        mData.add(new messageData("Dr Ahmed Shokry","do more exercise in this dy"));
        mData.add(new messageData("Dr Ahmed Shokry","do more exercise in this dy"));
        mData.add(new messageData("Dr Ahmed Shokry","do more exercise in this dy"));
        mData.add(new messageData("Dr Ahmed Shokry","do more exercise in this dy"));
        //////////////////////////////////////////////////////////////////////////////////////
        message_adapter=new message_adapter(mData);
        ////////////////////////////////////////////////////////////////////////////////////////////
        recyclerView.setAdapter(message_adapter);
        /////////////////////////////////////////////////////////////////////
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;


    }


}
