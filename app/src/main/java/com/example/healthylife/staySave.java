package com.example.healthylife;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.FusedLocationProviderClient;

import java.util.ArrayList;

import userSession.userData;

import static userSession.userData.keyFirstRelative;
import static userSession.userData.keySecondRealtive;


/**
 * A simple {@link Fragment} subclass.
 */
public class staySave extends Fragment implements View.OnClickListener {
    Button hide;
    Button requiredData;
    RecyclerView history;
    Spinner countrySpinner;
    LinearLayout requiredDataContainer;
    String[] countries={"Egypt","UK","USA"};
    userData user;
    EditText phone1;
    EditText phone2;
    Button save;
    private FusedLocationProviderClient fusedLocationClient;

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
       /* fusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                        }
                    }
                }); */
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_stay_save, container, false);
        intiateViews(root);
        spinner();
        recyclerContent();
        dataShow();

        hide.setOnClickListener(this);
        requiredData.setOnClickListener(this);
        save.setOnClickListener(this);
        return root;


    }
    public void intiateViews(View v){
        hide=v.findViewById(R.id.data_hide);
        requiredData=v.findViewById(R.id.required_data_button);
        countrySpinner=v.findViewById(R.id.country_spinner);
        requiredDataContainer=v.findViewById(R.id.status_data_countainer);
        phone1=v.findViewById(R.id.first_rel);
        phone2=v.findViewById(R.id.second_rel);
        user=new userData(getActivity());
        save=v.findViewById(R.id.data_save);
        history = v.findViewById(R.id.history_rv);

    }
    public void spinner(){
        ArrayAdapter dayAdapter=new ArrayAdapter(getActivity(),R.layout.spinnew_items,countries);
        dayAdapter.setDropDownViewResource(R.layout.spinnew_items);
        countrySpinner.setAdapter(dayAdapter);

    }
    public void recyclerContent(){
        ArrayList<statusHistoryData>newData=new ArrayList<statusHistoryData>();

        history.setLayoutManager(new LinearLayoutManager(getActivity()));
        statusHistoyAdpater statusHistoyAdpater=new statusHistoyAdpater(newData);
        history.setAdapter(statusHistoyAdpater);
        history.setItemAnimator(new DefaultItemAnimator());

    }
    private void dataShow(){

        String data1=user.getStaySaveData().get(keyFirstRelative);
        String data2=user.getStaySaveData().get(keySecondRealtive);
        if(data1!=null){
            phone1.setHint(data1);
            phone2.setHint(data2);

        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.data_hide:
                requiredDataContainer.setVisibility(View.GONE);
                requiredData.setVisibility(View.VISIBLE);
            case R.id.required_data_button:
                requiredDataContainer.setVisibility(View.VISIBLE);
                requiredData.setVisibility(View.GONE);
            case R.id.data_save:
                user.svaeStaySaveData(countrySpinner.getSelectedItem().toString(),phone1.getText().toString(),phone2.getText().toString());
                Toast.makeText(getActivity(),"data saved successfully ",Toast.LENGTH_SHORT).show();
        }
    }

}
