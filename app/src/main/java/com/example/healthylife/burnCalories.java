package com.example.healthylife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import userSession.userData;

public class burnCalories extends AppCompatActivity {
    private ImageView Gif;
    private ImageView backIcon;
    private Button go;
    private Button now;
    private Spinner day;
    private  Spinner month;
    private  Spinner year;
    private String d;
    private String m;
    private String y;
    private String randomKey;
    private userSession.userData newUser;
    private DatabaseReference databaseReference;
    private TextView b_counter;
    private  String []Days={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

    private  String []months={"january","febraury","march","april","may","june","july","august","september","octpber","november","december"};
    private  String []years={"2020","2021","2022","2023","2024"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burn_calories);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        b_counter=findViewById(R.id.b_counter);
        newUser=new userData(burnCalories.this);
        randomKey=newUser.getConnectionKey();
        b_counter.setText(newUser.getBurnCalories());
        go=findViewById(R.id.b_go);
        now=findViewById(R.id.b_now);
        //intiateDate();
        //create GIF
        Gif=findViewById(R.id.calories_gif);
        Glide.with(this).load(R.raw.exercise)
                .into(Gif);
        //back icon action
        backIcon=findViewById(R.id.heart_back_icon);
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(burnCalories.this,MainActivity.class);
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
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSelectedData();
            }
        });
        now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_counter.setText(newUser.getBurnCalories());
            }
        });


    }
    void intiateSpiner(Spinner spinner,String[] arr){

        ArrayAdapter dayAdapter=new ArrayAdapter(this,R.layout.spinnew_items,arr);
        dayAdapter.setDropDownViewResource(R.layout.spinnew_items);
        spinner.setAdapter(dayAdapter);
    }
    private void intiateDate(){
        d=day.getSelectedItem().toString();
        m=Integer.toString(month.getSelectedItemPosition());
        y=year.getSelectedItem().toString();

    }
    private   void getSelectedData(){

        databaseReference.child("data").child(randomKey).child(y).child(m).child(d).child("bloodPressure").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                b_counter.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(burnCalories.this, "no data for this day", Toast.LENGTH_SHORT).show();

            }
        });

    }




}
