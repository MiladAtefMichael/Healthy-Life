package com.example.healthylife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthylife.firebase.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import userSession.userData;

import static com.example.healthylife.R.drawable.un_active_shape;

public class signUp extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    EditText password;
    EditText email;
    EditText clinic_name;
    EditText clinic_password;
    ImageView doctor;
    ImageView user;
    Button signup;
    ImageView back;
    userData newUser;
    Boolean isDoctor=true;
    String data1;
    String data2;
    String data3;
    String data4;
    String data5;
    String userKey;
    Boolean checker = false;
    private DatabaseReference databaseReference;
    private DatabaseReference clinicRef;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        newUser=new userData(signUp.this);
        initViews();
        initiateData();
        back.setOnClickListener(this);
        user.setOnClickListener(this);
        doctor.setOnClickListener(this);
        signup.setOnClickListener(this);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        clinicRef=FirebaseDatabase.getInstance().getReference("clinics");

    }
    private void initViews(){
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        clinic_name=findViewById(R.id.clinic_name);
        clinic_password=findViewById(R.id.clinic_password);
        password=findViewById(R.id.password);
        doctor=findViewById(R.id.doctor);
        user=findViewById(R.id.user);
        signup=findViewById(R.id.signup);
        back=findViewById(R.id.signup_back);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.user:
                user.setBackground(getDrawable(R.drawable.active_image_shape));
                doctor.setBackground(getDrawable(un_active_shape));
                clinic_name.setVisibility(View.GONE);
                clinic_password.setVisibility(View.GONE);
                isDoctor=false;
                break;
            case R.id.doctor:
                doctor.setBackground(getDrawable(R.drawable.active_image_shape));
                user.setBackground(getDrawable(un_active_shape));
                clinic_name.setVisibility(View.VISIBLE);
                clinic_password.setVisibility(View.VISIBLE);
                isDoctor=true;
                break;
            case R.id.signup:
                initiateData();
                Intent intent=new Intent(signUp.this,MainActivity.class);
                if(isDoctor&&validateUserData()&&validateDoctorData()){

                    signup(email.getText().toString(),password.getText().toString());
                        addUser();
                    addCinic(clinic_name.getText().toString(),clinic_password.getText().toString(),name.getText().toString());
                    saveData();}
                startActivity(intent);
                if(!isDoctor&&validateUserData()) {
                    signup(email.getText().toString(), password.getText().toString());
                        saveData();
                        addUser();
                        startActivity(intent);

                }

                break;
            case R.id.signup_back:
                Intent intent2=new Intent(signUp.this,signIn.class);
                startActivity(intent2);
                break;
        }
    }
   private void saveData(){
        Boolean haveAccount=true;
       newUser.saveData(haveAccount,isDoctor,data1,data2,data3);
       newUser.saveStatus(true);
       if(isDoctor){

           newUser.saveDoctorData(data4,data5);
       }
    }
    private void initiateData(){
        data1=name.getText().toString();
        data2=email.getText().toString();
        data3=password.getText().toString();
        data4=clinic_name.getText().toString();
        data5=clinic_password.getText().toString();
    }
    private Boolean validateUserData(){
      if(data1.isEmpty()){
          Toast.makeText(signUp.this,"please enter your name",Toast.LENGTH_SHORT).show();
          return false;
      }
      else if(data2.isEmpty()){
            Toast.makeText(signUp.this,"please enter your email",Toast.LENGTH_SHORT).show();
            return false;
        }
      else if(!data2.matches( "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
          Toast.makeText(signUp.this,"please enter valid email",Toast.LENGTH_SHORT).show();
          return false;
      }
      else if (data3.isEmpty()){
          Toast.makeText(signUp.this,"please enter your password",Toast.LENGTH_SHORT).show();
          return false;
      }
      else if (data3.length()<=3){
          Toast.makeText(signUp.this,"your password is too short",Toast.LENGTH_SHORT).show();
          return false;
      }
      else{ return true;}

    }
    private Boolean validateDoctorData(){
        if(data4.isEmpty()){
            Toast.makeText(signUp.this,"please enter your clinic name",Toast.LENGTH_SHORT).show();
            return false;
        }

        else if (data5.isEmpty()){
            Toast.makeText(signUp.this,"please enter your clinic password",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (data5.length()<=3){
            Toast.makeText(signUp.this,"clinic password is too short",Toast.LENGTH_SHORT).show();
            return false;
        }
        else{ return true;}

    }

    void addUser(){
         userKey= mAuth.getCurrentUser().getUid();
        com.example.healthylife.firebase.user newUser= new user(name.getText().toString(),email.getText().toString());
        databaseReference.child("users").child(userKey).setValue(newUser);
    }
 private void signup(String email,String password){

    mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(signUp.this, "data saved successfully",
                                Toast.LENGTH_SHORT).show();


                    } else {
                        // If sign in fails, display a message to the user.

                        Toast.makeText(signUp.this, "something go wrong..try again",
                                Toast.LENGTH_SHORT).show();



                    }


                }
            });

}
void addCinic(String clinicName,String clinicPassword,String doctorName){
        clinicRef.child(clinicName).child("password").setValue(clinicPassword);
        clinicRef.child(clinicName).child("doctor_name").setValue(doctorName);
        databaseReference.child("users").child(userKey).child("isDoctor").setValue("true");
        databaseReference.child("users").child(userKey).child("clinic").child("clinicName").setValue(clinicName);
        databaseReference.child("users").child(userKey).child("clinic").child("clinicPassword").setValue(clinicPassword);

}


}

