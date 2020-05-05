package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {
    ImageView logo;
    Animation anim;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = findViewById(R.id.logo);
        anim = AnimationUtils.loadAnimation(this, R.anim.logo_anim);
        title=findViewById(R.id.title);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                title.setVisibility(View.VISIBLE);
                splashTimer();

            }


            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        logo.startAnimation(anim);
    }
        public void splashTimer(){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(splash.this, signIn.class);
                    startActivity(intent);

                }
            }, 1000);
        }
    }

