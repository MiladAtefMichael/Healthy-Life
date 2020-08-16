package com.example.healthylife;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class messageFragment extends Fragment {
message_adapter message_adapter;
private DatabaseReference databaseReference;
private FirebaseAuth mAuth;
    ArrayList<messageData> mData=new ArrayList<messageData>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER




    public messageFragment() { }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_message, container, false);
        if (container != null) {
            container.removeAllViews();
        }
        mAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.message_rv);
        mData=new ArrayList<messageData>();
        getMessages();




        //////////////////////////////////////////////////////////////////////////////////////
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        message_adapter=new message_adapter(mData);
        recyclerView.setAdapter(message_adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;


    }
    private void getMessages(){
        String userKey=mAuth.getCurrentUser().getUid();
        databaseReference.child("user").child(userKey).child("messages").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mData.add(new messageData(snapshot.child("doctorName").getValue(String.class),snapshot.child("message").getValue(String.class)));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "no data to show ", Toast.LENGTH_SHORT).show();

            }
        });
    }



}
