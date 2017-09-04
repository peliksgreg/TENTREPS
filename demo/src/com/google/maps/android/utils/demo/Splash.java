package com.google.maps.android.utils.demo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.maps.android.utils.demo.MainActivity;
import com.google.maps.android.utils.demo.R;

import java.util.Random;


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