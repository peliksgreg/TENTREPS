package com.google.maps.android.utils.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class Splash extends AppCompatActivity {
    private static int TIMEOUT = 3500;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(Splash.this, Login.class);
                startActivity(welcome);

                overridePendingTransition(R.anim.translate, R.anim.alpha);
                finish();
            }
        }, TIMEOUT);

    }

}