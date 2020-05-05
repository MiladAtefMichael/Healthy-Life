package com.example.healthylife;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class staySave extends Fragment {
    Button hide;
    Button requiredData;
    RecyclerView history;
    Spinner countrySpinner;
    LinearLayout requiredDataContainer;
    String[] countries={"Egypt","UK","USA"};



    public staySave() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //clean view
        if (container != null) {
            container.removeAllViews();
        }

        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_stay_save, container, false);
        hide=root.findViewById(R.id.data_hide);
        requiredData=root.findViewById(R.id.required_data_button);
        countrySpinner=root.findViewById(R.id.country_spinner);
        requiredDataContainer=root.findViewById(R.id.status_data_countainer);


        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requiredDataContainer.setVisibility(View.GONE);
                requiredData.setVisibility(View.VISIBLE);



            }
        });
//////////////////////////////////////////////////////////////////////////////////////
        requiredData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requiredDataContainer.setVisibility(View.VISIBLE);
                requiredData.setVisibility(View.GONE);

            }
        });
        //set spinner of countries
        ArrayAdapter dayAdapter=new ArrayAdapter(getActivity(),R.layout.spinnew_items,countries);
        dayAdapter.setDropDownViewResource(R.layout.spinnew_items);
        countrySpinner.setAdapter(dayAdapter);
        //set array of history list
        ArrayList<statusHistoryData>newData=new ArrayList<statusHistoryData>();
        newData.add(new statusHistoryData("10/2/2021","50","180/30"));
        newData.add(new statusHistoryData("10/2/2021","50","180/30"));
        newData.add(new statusHistoryData("10/2/2021","50","180/30"));
        //set recycler view
      history = (RecyclerView) root.findViewById(R.id.history_rv);

        // 2. set layoutManger
        history.setLayoutManager(new LinearLayoutManager(getActivity()));
        statusHistoyAdpater statusHistoyAdpater=new statusHistoyAdpater(newData);
        ////////////////////////////////////////////////////////////////////////////////////////////
        history.setAdapter(statusHistoyAdpater);
        /////////////////////////////////////////////////////////////////////
        history.setItemAnimator(new DefaultItemAnimator());
        return root;
    }


}
