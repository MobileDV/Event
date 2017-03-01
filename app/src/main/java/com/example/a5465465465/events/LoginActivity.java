package com.example.a5465465465.events;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 5465465465 on 2/6/2017.
 */

public class LoginActivity extends Activity {
    ImageView image1,image2;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        image1=(ImageView)findViewById(R.id.imageView2);
        image1.setImageResource(R.drawable.google);
        image2=(ImageView)findViewById(R.id.imageView3);
        image2.setImageResource(R.drawable.face);

        image1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        image2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}



