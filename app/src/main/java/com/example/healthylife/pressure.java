package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;

public class pressure extends AppCompatActivity {
    private ImageView Gif;
    private ImageView backIcon;
    private  Spinner day;
    private  Spinner month;
    private  Spinner year;
    private  String []Days={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

    private  String []months={"january","febraury","march","april","may","june","july","august","september","octpber","november","december"};
    private  String []years={"2020","2021","2022","2023","2024"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        //create GIF
        Gif=findViewById(R.id.pressure_gif);
        Glide.with(this).load(R.raw.pressure)
                .into(Gif);
        //back icon action
        backIcon=findViewById(R.id.heart_back_icon);
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(pressure.this,MainActivity.class);
                startActivity(intent);

            }
        });
        day=findViewById(R.id.day);
        intiateSpiner(day,Days);

        ////////////////////////////////////////////
        month=findViewById(R.id.month);
        intiateSpiner(month,months);

        ///////////////////////////////////////////////////////////
        year=findViewById(R.id.year);
        intiateSpiner(year,years);


    }
    void intiateSpiner(Spinner spinner,String[] arr){

        ArrayAdapter dayAdapter=new ArrayAdapter(this,R.layout.spinnew_items,arr);
        dayAdapter.setDropDownViewResource(R.layout.spinnew_items);

        spinner.setAdapter(dayAdapter);
    }


}

