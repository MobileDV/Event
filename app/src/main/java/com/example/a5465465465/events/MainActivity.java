package com.example.a5465465465.events;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a5465465465.events.Helper.DBHelper;
import com.example.a5465465465.events.Model.Event;
import com.example.a5465465465.events.Utils.Common;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout lyListView;
    private EditText etZip, etCategory;
    private List<Event> listEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initSetting();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presentEventList();
    }

    private void initSetting() {
        Common.getInstance().dbHelper = new DBHelper(getApplicationContext());
        Common.getInstance().listEvents = Common.getInstance().dbHelper.getAllEvents();
    }

    private void initUI () {
        ImageView image3 = (ImageView) findViewById(R.id.imgmainBack);
        image3.setImageResource(R.drawable.backbutton);

        lyListView = (LinearLayout)findViewById(R.id.listview);
        etZip = (EditText)findViewById(R.id.search_zip);
        etCategory = (EditText)findViewById(R.id.search_category);

        findViewById(R.id.imgmainBack).setOnClickListener(this);
        findViewById(R.id.btn_add_data).setOnClickListener(this);
        findViewById(R.id.btnFilter).setOnClickListener(this);
    }

    private void presentEventList() {
        lyListView.removeAllViews();

        LayoutInflater inflater = LayoutInflater.from(getBaseContext());
        for(int i = 0; i < Common.getInstance().listEvents.size(); i ++) {
            Event eventItem = Common.getInstance().listEvents.get(i);
            final int nIdx = i;
            View cell = inflater.inflate(R.layout.cell_event_item, null);

            ((TextView)cell.findViewById(R.id.tvTitle)).setText(eventItem.get_title());
            ((TextView)cell.findViewById(R.id.tvDescription)).setText(eventItem.get_description());

            cell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Common.getInstance().nCurrentEventIndex = nIdx;
                    Intent i = new Intent(MainActivity.this, DetailActivity.class);
                    startActivity(i);
                }
            });

            lyListView.addView(cell);
        }
    }

    private void filterByZip(String strZip) {
        Common.getInstance().listEvents = Common.getInstance().dbHelper.getEventsWithZip(strZip);
        presentEventList();
    }

    private void filterByCategory(String strCategory) {
        Common.getInstance().listEvents = Common.getInstance().dbHelper.getEventsWithCategory(strCategory);
        presentEventList();
    }

    private void showAllEvents() {
        Common.getInstance().listEvents = Common.getInstance().dbHelper.getAllEvents();
        presentEventList();
    }



    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.imgmainBack) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        } else if (view.getId() == R.id.btn_add_data) {
            Intent intent = new Intent(MainActivity.this, UploadActivity.class);
            startActivity(intent);

        } else if (view.getId() == R.id.btnFilter) {
            String strZip = etZip.getText().toString();
            String strCategory = etCategory.getText().toString();

            if(strZip.length() > 0) {
                filterByZip(strZip);
            } else if(strCategory.length() > 0) {
                filterByCategory(strCategory);
            } else {
                showAllEvents();
            }

        }
    }
}

