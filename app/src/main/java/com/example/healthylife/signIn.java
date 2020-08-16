package com.example.healthylife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import userSession.userData;

import static userSession.userData.keyEmail;
import static userSession.userData.keyPassword;

public class signIn extends AppCompatActivity {
    Button signin;
    Button newacc;
    EditText email;
    EditText password;
    String actulEmail;
    String actulPassword;
    String inputEmail;
    String inputPassword;
    userData user;
    Query login;
    private FirebaseAuth mAuth;
    ArrayList<com.example.healthylife.firebase.user> list;
    private  DatabaseReference databaseReference;
    com.example.healthylife.firebase.user loginUser;
     ArrayList<String> ArrayList1;
     ArrayList<String> ArrayList2;
     int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        intiateViews();
        intiateData();
        mAuth = FirebaseAuth.getInstance();
        list=new ArrayList<com.example.healthylife.firebase.user>();
        databaseReference= FirebaseDatabase.getInstance().getReference("users");
         ArrayList1 =new ArrayList<String>();
        ArrayList2 =new ArrayList<String>();

        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               /* if(actulEmail==inputEmail&&actulPassword==inputPassword

                   inputPassword.equals(list.get(0).getUserPassword())){


                Intent intent=new Intent(signIn.this,MainActivity.class);
                startActivity(intent);
                user.saveStatus(true);}
                else{
                    Toast.makeText(signIn.this,"email or password is not correct",Toast.LENGTH_SHORT).show();
                }*/
               logIn(inputEmail,inputPassword);
            }
        });
        newacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signIn.this,signUp.class);
                startActivity(intent);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               /* if(actulEmail==inputEmail&&actulPassword==inputPassword

                   inputPassword.equals(list.get(0).getUserPassword())){


                Intent intent=new Intent(signIn.this,MainActivity.class);
                startActivity(intent);
                user.saveStatus(true);}
                else{
                    Toast.makeText(signIn.this,"email or password is not correct",Toast.LENGTH_SHORT).show();
                }*/
                logIn(email.getText().toString(),password.getText().toString());
            }
        });

    }
    private void intiateViews(){
        signin=findViewById(R.id.signin);
        newacc=findViewById(R.id.new_account);
        email=findViewById(R.id.signin_email);
        password=findViewById(R.id.signin_password);
        user=new userData(signIn.this);

    }
    private void intiateData(){
      actulEmail=user.getUserData().get(keyEmail) ;
      actulPassword=user.getUserData().get(keyPassword);
       inputEmail=email.getText().toString();
       inputPassword=password.getText().toString();
    }
  /*  void signin() {

     login = databaseReference.child("-MDrx3r0TSdQf60vpsJ9")
                .child("userEmail").equalTo(email.getText().toString());


        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                loginUser=snapshot.getValue(com.example.healthylife.firebase.user.class);
                list.add(loginUser);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                loginUser=snapshot.getValue(com.example.healthylife.firebase.user.class);
                list.add(loginUser);

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }   */
  void logIn(String email,String password){
      mAuth.signInWithEmailAndPassword(email, password)
              .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if (task.isSuccessful()) {
                          // Sign in success, update UI with the signed-in user's information
                          final FirebaseUser user = mAuth.getCurrentUser();
                          Intent intent=new Intent(signIn.this,MainActivity.class);
                          startActivity(intent);

                      } else {
                          // If sign in fails, display a message to the user.

                          Toast.makeText(signIn.this, "Authentication failed.",
                                  Toast.LENGTH_SHORT).show();

                          // ...
                      }

                      // ...
                  }
              });
  }

            @Override

            protected void onStart() {
                super.onStart();


            }

        }
