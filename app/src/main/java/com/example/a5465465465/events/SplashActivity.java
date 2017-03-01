package com.example.a5465465465.events;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

/**
 * Created by 5465465465 on 2/6/2017.
 */

public class SplashActivity extends Activity {
    private static int SPLASH_TIME_OUT=3000;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imgcenter=(ImageView)findViewById(R.id.img_center);
        imgcenter.setImageResource(R.drawable.screen);

        ImageView imgtop=(ImageView)findViewById(R.id.img_top);
        imgtop.setImageResource(R.drawable.topp);

        ImageView imgbelo=(ImageView)findViewById(R.id.img_belo);
        imgbelo.setImageResource(R.drawable.topp);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

                finish();
            }
        },SPLASH_TIME_OUT);

    }


}
