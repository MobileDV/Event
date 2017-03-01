package com.example.a5465465465.events.Utils;

import com.example.a5465465465.events.Helper.DBHelper;
import com.example.a5465465465.events.Model.Event;

import java.util.List;

/**
 * Created by Administrator on 2/13/2017.
 */

public class Common {
    static Common instance = null;

    public static Common getInstance() {
        if(instance == null){
            instance = new Common();
        }

        return instance;
    }

    public DBHelper dbHelper;
    public List<Event> listEvents;
    public int nCurrentEventIndex;
}
