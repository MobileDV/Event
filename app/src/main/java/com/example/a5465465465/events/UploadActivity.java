package com.example.a5465465465.events;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a5465465465.events.Helper.DBHelper;
import com.example.a5465465465.events.Model.Event;
import com.example.a5465465465.events.Utils.Common;

import static com.example.a5465465465.events.R.id.eventID;

/**
 * Created by 5465465465 on 2/7/2017.
 */

public class UploadActivity extends Activity implements View.OnClickListener {
    TextView title;
    TextView description;
    TextView date;
    TextView place;
    TextView personal;
    TextView category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        initUI();
    }

    private void initUI() {
        title=(TextView)findViewById(R.id.contact_title);
        description=(TextView)findViewById(R.id.contact_description);
        date=(TextView)findViewById(R.id.contact_date);
        place=(TextView)findViewById(R.id.contact_place);
        personal=(TextView)findViewById(R.id.contact_person);
        category=(TextView)findViewById(R.id.contact_category);

        ImageView imag5 = (ImageView) findViewById(R.id.imgup_back);
        imag5.setImageResource(R.drawable.backbutton);

        findViewById(R.id.btn_uplod).setOnClickListener(this);
        findViewById(R.id.imgup_back).setOnClickListener(this);
    }

    private void uploadEventInfo() {
        String strTitle = title.getText().toString();
        String strDescription = description.getText().toString();
        String strDate = date.getText().toString();
        String strPlace = place.getText().toString();
        String strPerson = personal.getText().toString();
        String strCategory = category.getText().toString();

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

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_uplod) {
            uploadEventInfo();
        } else if(view.getId() == R.id.imgup_back) {
            Intent i = new Intent(UploadActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }
}