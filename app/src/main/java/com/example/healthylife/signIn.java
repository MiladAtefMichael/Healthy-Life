package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signIn extends AppCompatActivity {
    Button signin;
    Button newacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signin=findViewById(R.id.signin);
        newacc=findViewById(R.id.new_account);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signIn.this,MainActivity.class);
                startActivity(intent);
            }
        });
        newacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signIn.this,signUp.class);
                startActivity(intent);
            }
        });

    }
}
