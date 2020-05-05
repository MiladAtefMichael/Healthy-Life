package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.healthylife.R.drawable.un_active_shape;

public class signUp extends AppCompatActivity {
    EditText name;
    EditText password;
    EditText email;
    EditText username;
    ImageView doctor;
    ImageView user;
    Button signup;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

         name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        doctor=findViewById(R.id.doctor);
        user=findViewById(R.id.user);
        signup=findViewById(R.id.signup);
        back=findViewById(R.id.signup_back);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user.setBackground(getDrawable(R.drawable.active_image_shape));
                doctor.setBackground(getDrawable(un_active_shape));
                username.setVisibility(View.GONE);



            }
        });
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doctor.setBackground(getDrawable(R.drawable.active_image_shape));
                user.setBackground(getDrawable(un_active_shape));
               username.setVisibility(View.VISIBLE);



            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signUp.this,MainActivity.class);
                startActivity(intent);


                }



        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signUp.this,signIn.class);
                startActivity(intent);
            }
        });
    }


    }

