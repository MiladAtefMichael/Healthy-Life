package com.example.healthylife;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import userSession.userData;


/**
 * A simple {@link Fragment} subclass.
 */
public class connect extends DialogFragment {
    private Button connect;
    private  Button cancel;
    private EditText input;
    private DatabaseReference databaseReference;
    private userSession.userData newUser;

    private FirebaseAuth mAuth;

    public connect() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_connect, container, false);
        connect=root.findViewById(R.id.connect);
        cancel=root.findViewById(R.id.cancel_connect);
        input=root.findViewById(R.id.code);
        mAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        newUser=new userData(getActivity());
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input.getText().toString().isEmpty() && input.getText().toString().length()==4){
                String currentUser=mAuth.getCurrentUser().getUid();
                databaseReference.child("users").child(currentUser).child("dataKey").setValue(input.getText().toString());
                newUser.saveConnectionKey(input.getText().toString());
                Toast.makeText(getActivity(), "connected successfully", Toast.LENGTH_SHORT).show();
                dismiss();}
                else {
                    Toast.makeText(getActivity(), "invalid key", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        return root;
    }
}
