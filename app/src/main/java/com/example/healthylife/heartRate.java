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

public class heartRate extends AppCompatActivity {
   private ImageView Gif;
   private ImageView backIcon;
   private Button go;
   private Button now;
    private  Spinner day;
    private  Spinner month;
    private  Spinner year;
    private String d;
    private String m;
    private String y;
    private TextView counter;
    private DatabaseReference databaseReference;
    private userSession.userData newUser;
    private String randomKey;
    private  String []Days={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

    private  String []months={"january","febraury","march","april","may","june","july","august","september","octpber","november","december"};
    private  String []years={"2020","2021","2022","2023","2024"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate);
        counter=findViewById(R.id.counter);
        go=findViewById(R.id.go_heart);
        now=findViewById(R.id.h_now);


        databaseReference= FirebaseDatabase.getInstance().getReference();
        newUser=new userData(heartRate.this);
        randomKey=newUser.getConnectionKey();


        //create GIF
        Gif=findViewById(R.id.rate_gif);
        Glide.with(this).load(R.raw.heart_rate)
                .into(Gif);
        //back icon action
        backIcon=findViewById(R.id.heart_back_icon);
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(heartRate.this,MainActivity.class);
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

       counter.setText(newUser.getHeartRate());
       go.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getSelectedData();
           }
       });
       now.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               counter.setText(newUser.getHeartRate());
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
     m=String.valueOf(month.getSelectedItemPosition());
     y=year.getSelectedItem().toString();

 }
    private   void getSelectedData(){

        databaseReference.child("data").child(randomKey).child(y).child(m).child(d).child("bloodPressure").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                counter.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(heartRate.this, "no data for this day", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
