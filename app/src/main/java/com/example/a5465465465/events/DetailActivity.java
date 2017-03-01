package com.example.a5465465465.events;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a5465465465.events.Model.Event;
import com.example.a5465465465.events.Utils.Common;

/**
 * Created by 5465465465 on 2/7/2017.
 */

public class DetailActivity extends Activity implements View.OnClickListener {

    TextView tvTitle,tvDescription, tvDate, tvPlace, tvPersonal, tvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initUI();
        setInfo();
    }

    private void initUI() {
        ImageView imagedata=(ImageView) findViewById(R.id.image_hm);
        imagedata.setImageResource(R.drawable.deta);

        ImageView imag4 = (ImageView) findViewById(R.id.img_dedaback);
        imag4.setImageResource(R.drawable.backbutton);
        imag4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.btn_save).setOnClickListener(this);

        tvTitle = (TextView)findViewById(R.id.txttitle);
        tvDescription = (TextView)findViewById(R.id.txtdescription);
        tvDate = (TextView)findViewById(R.id.txtdate);
        tvPlace = (TextView)findViewById(R.id.txtplace);
        tvPersonal = (TextView)findViewById(R.id.txtPerson);
        tvCategory = (TextView)findViewById(R.id.txtcategory);
    }

    private void setInfo() {
        Event event = Common.getInstance().listEvents.get(Common.getInstance().nCurrentEventIndex);

        tvTitle.setText(event.get_title());
        tvDescription.setText(event.get_description());
        tvDate.setText(event.get_date());
        tvPlace.setText(event.get_zip());
        tvPersonal.setText(event.get_person());
        tvCategory.setText(event.get_category());
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_save) {
            uploadEventInfo();
        } else if(view.getId() == R.id.imgup_back) {
            Intent i = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }

    }

    private void uploadEventInfo() {
        String strTitle = tvTitle.getText().toString();
        String strDescription = tvDescription.getText().toString();
        String strDate = tvDate.getText().toString();
        String strPlace = tvPlace.getText().toString();
        String strPerson = tvPersonal.getText().toString();
        String strCategory = tvCategory.getText().toString();

        if(strTitle.length() == 0) {
            Toast.makeText(getBaseContext(), "Please input the title", Toast.LENGTH_SHORT).show();
            return;
        }

        if(strDescription.length() == 0) {
            Toast.makeText(getBaseContext(), "Please input the description", Toast.LENGTH_SHORT).show();
            return;
        }

        if(strDate.length() == 0) {
            Toast.makeText(getBaseContext(), "Please input the date", Toast.LENGTH_SHORT).show();
            return;
        }

        if(strPlace.length() == 0) {
            Toast.makeText(getBaseContext(), "Please input the place", Toast.LENGTH_SHORT).show();
            return;
        }

        if(strPerson.length() == 0) {
            Toast.makeText(getBaseContext(), "Please input the person", Toast.LENGTH_SHORT).show();
            return;
        }

        if(strCategory.length() == 0) {
            Toast.makeText(getBaseContext(), "Please input the place", Toast.LENGTH_SHORT).show();
            return;
        }

        Event event = new Event(strTitle, strDescription, strDate, strPlace, strPerson, strCategory);
        int event_id = Common.getInstance().dbHelper.createEvent(event);

        event.set_id(event_id);
        Common.getInstance().listEvents.add(event);

        Toast.makeText(getBaseContext(), "New event info has been saved successfully", Toast.LENGTH_SHORT).show();

        finish();
    }
}



