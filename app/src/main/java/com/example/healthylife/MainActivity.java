package com.example.healthylife;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.example.healthylife.homeFragment;
import com.example.healthylife.messageFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {
/*  ImageView heartGif;
    ImageView preesure;
    ImageView exercise;
    ImageView sleep;*/

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.nav_view);

         bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

    /*  heartGif=heartGif. findViewById(R.id.heart_gif);
        Glide.with(this).load(R.raw.heart_rate).into(heartGif);
        preesure= preesure.findViewById(R.id.pressure);
        Glide.with(this).load(R.raw.pressure).into(preesure);
        exercise=exercise.findViewById(R.id.exercise);
        Glide.with(this).load(R.raw.exercise).into(exercise);
        sleep=sleep.findViewById(R.id.sleep);
        Glide.with(this).load(R.raw.sleep).into(sleep);
        openFragment(new homeFragment());*/
        /*AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.messageFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigation, navController);*/

}

  private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, fragment);
       // transaction.addToBackStack(null);
        transaction.commit();
    }

 BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.home:

                            openFragment(new homeFragment());
                            return true;
                        case R.id.message:
                            openFragment(new messageFragment());
                            return true;
                        case R.id.risk:
                           openFragment(new getStarted());
                           return true;

                    }
                    return false;
                }
            };

}


        /*//////////////////////////////////////////////////////////////////////////////////////////////
       /* BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_message)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);*/
        ////////////////////////////////////////////////////////////////////////////////*/










        //////////////////////////////////////////////////////////////////////////////////////////////


       /* final ImageView message=findViewById(R.id.message_image);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_container,new messageFragment()).commit();
            }
        });*/
