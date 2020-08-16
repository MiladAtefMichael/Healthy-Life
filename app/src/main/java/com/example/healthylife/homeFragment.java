package com.example.healthylife;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

import userSession.userData;


/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {

    RecyclerView recyclerView;
  private  itemsAdapter itemAdapter;
  private  RelativeLayout heart;
 private   RelativeLayout pressure;
 private    RelativeLayout excercise;

 private userSession.userData user;
 private HashMap<Integer,String> heartAdvices;
 private HashMap<Integer,String> pressureAdvices;
 private HashMap<Integer,String> calAdvices;
 TextView Rtext;
 TextView ptext;
 TextView btext;
 private String heartRate;
 private String burnCal;
 private String bloodPressure;
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
        user=new userData(getActivity());
       heartAdvices=new HashMap<Integer, String>();
        pressureAdvices=new HashMap<Integer, String>();
        calAdvices=new HashMap<Integer, String>();
        loadData();

        heartRate=user.getHeartRate();
        bloodPressure=user.getBloodPressure();
        burnCal=user.getBurnCalories();
        Rtext=root.findViewById(R.id.heart_rate_text);
        ptext=root.findViewById(R.id.pressure_text);
        btext=root.findViewById(R.id.exercise_text);
        Rtext.setText(heartRate);
        ptext.setText(bloodPressure);
        btext.setText(burnCal);
       int advice1=(Integer.parseInt(heartRate)-50)/7;
        String p="";
       for(int i=0;i<bloodPressure.length();i++){
           p=p+bloodPressure.charAt(i);
           if (bloodPressure.charAt(i)=='/'){
               break;
           }
        }
        int advice2=5;
        int advice3=(Integer.parseInt(burnCal)-1000)/100;

        ArrayList<data> mydata=new ArrayList<data>();
        mydata.add(new data(heartAdvices.get(advice1)));
        mydata.add(new data(pressureAdvices.get(advice2)));
        mydata.add(new data(calAdvices.get(advice3)));
        mydata.add(new data("enjoy this day"));



        RecyclerView recyclerView = root.findViewById(R.id.rv);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        itemAdapter=new itemsAdapter(mydata);
        ////////////////////////////////////////////////////////////////////////////////////////////
        recyclerView.setAdapter(itemAdapter);
        /////////////////////////////////////////////////////////////////////
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        //heart icon click action
       heart= root.findViewById(R.id.heart);
       pressure=root.findViewById(R.id.pressure);
       excercise=root.findViewById(R.id.exercise);

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


        return root;
    }
    void loadData(){
     //heart Rate dataset
     heartAdvices.put(1,"your heart rate is too low application will call ambulance now");
        heartAdvices.put(2,"  heart rate is low .please check doctor advices and go ahead with that");
        heartAdvices.put(3,"there is some food to get more heart health : Leafy Green Vegetables - Whole Grains-  Berries -Avocados - Fatty Fish and Fish Oil");
        heartAdvices.put(4," heart rate that day is better just do more exercise");
        heartAdvices.put(5, "your heart rate in the stable that day . Have a good day");
        heartAdvices.put(6,"heart rate that day is better just have more rest time");
        heartAdvices.put(7,"there is some food to get more heart health : Leafy Green Vegetables - Whole Grains-  Berries -Avocados - Fatty Fish and Fish Oil");
        heartAdvices.put(8,"there is some food to get more heart health : Leafy Green Vegetables - Whole Grains-  Berries -Avocados - Fatty Fish and Fish Oil .and have more rest time");
        heartAdvices.put(19, "heart rate is high .please check doctor advices and go ahead with that");
        heartAdvices.put(10," your heart rate is high low application will call ambulance now");
        //blooad pressure dataset
       pressureAdvices.put(1," your blood pressure is too low application will call ambulance now ");
       pressureAdvices.put(2," blood pressure is low in the first just keep on healthy life style for amonth if this doesn't help ask your doctor for treatment");
       pressureAdvices.put(3," your blood pressure is good keep with this healthy life style");
       pressureAdvices.put(4," blood pressure slightly high there's some food could help with that : Leafy greens-  Berries -Red beets - Oatmeal- Bananas");
       pressureAdvices.put(5," blood pressure is high in the first just keep on healthy life style for amonth if this doesn't help ask your doctor for treatment");
       pressureAdvices.put(6," blood pressure is high in the second level you have to see doctor . If you have your tratment  drinking skin milk now could help");
       pressureAdvices.put(7," your blood pressure is too high application will call ambulance now");
      // burn calories dataset
       calAdvices.put(1," your burn calories is too low you have to see doctor nowdays could be a problem with Thyroid ");
       calAdvices.put(2," burn calories is less than normal range please have more exercise ");
       calAdvices.put(3," you have minumam range of burn calories . Keep doing and burn more fat");
       calAdvices.put(4," stable range of burn calories");
       calAdvices.put(5," great numbe of burn calories good job");
       calAdvices.put(6," new great record of burn calories good job");
       calAdvices.put(7," great record of burn calories take care about your diet system to get suitable weight");


    }



}
