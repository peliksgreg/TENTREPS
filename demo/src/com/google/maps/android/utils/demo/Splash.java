package com.google.maps.android.utils.demo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Splash extends Activity {
    private static int WELCOME_TIMEOUT = 4000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(Splash.this, Login.class);
                startActivity(welcome);

                overridePendingTransition(R.anim.fadein, R.anim.fadout);
                finish();

            }
        }, WELCOME_TIMEOUT);

    }


}