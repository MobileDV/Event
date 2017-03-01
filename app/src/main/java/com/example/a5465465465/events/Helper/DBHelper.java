package  com.example.a5465465465.events.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.a5465465465.events.Model.Event;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 5465465465 on 2/9/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";
    // Database Version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "Event";

    //table names
    private static final String TBL_EVENT = "Event";

    //event table keys
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_DATE = "date";
    private static final String KEY_ZIP = "zip";
    private static final String KEY_PERSON = "person";
    private static final String KEY_CATEGORY = "category";

    // Event table create statement
    private static final String CREATE_TABLE_EVENT = "CREATE TABLE IF NOT EXISTS "
            + TBL_EVENT + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE
            + " TEXT," + KEY_DESCRIPTION + " TEXT," + KEY_DATE + " TEXT,"
            + KEY_ZIP + " TEXT," + KEY_PERSON + " TEXT, " + KEY_CATEGORY + " TEXT" + ")";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_EVENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TBL_EVENT);

        // create new tables
        onCreate(db);
    }

    // ------------------------ "event" table methods ----------------//
	/*
	 * Creating a event
	 */

    public int createEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, event.get_title());
        values.put(KEY_DESCRIPTION, event.get_description());
        values.put(KEY_DATE, event.get_date());
        values.put(KEY_ZIP, event.get_zip());
        values.put(KEY_PERSON, event.get_person());
        values.put(KEY_CATEGORY, event.get_category());

        // insert row
        long event_id = db.insert(TBL_EVENT, null, values);

        return (int)event_id;
    }

    /*
     * get single event
     */
    public Event getEvent(int event_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TBL_EVENT + " WHERE "
                + KEY_ID + " = " + event_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Event event = new Event();
        event.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
        event.set_title(c.getString(c.getColumnIndex(KEY_TITLE)));
        event.set_description(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
        event.set_date(c.getString(c.getColumnIndex(KEY_DATE)));
        event.set_zip(c.getString(c.getColumnIndex(KEY_ZIP)));
        event.set_person(c.getString(c.getColumnIndex(KEY_PERSON)));
        event.set_category(c.getString(c.getColumnIndex(KEY_CATEGORY)));

        return event;
    }

    /**
     * getting all events
     * */
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<Event>();
        String selectQuery = "SELECT  * FROM " + TBL_EVENT;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Event event = new Event();
                event.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                event.set_title(c.getString(c.getColumnIndex(KEY_TITLE)));
                event.set_description(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
                event.set_date(c.getString(c.getColumnIndex(KEY_DATE)));
                event.set_zip(c.getString(c.getColumnIndex(KEY_ZIP)));
                event.set_person(c.getString(c.getColumnIndex(KEY_PERSON)));
                event.set_category(c.getString(c.getColumnIndex(KEY_CATEGORY)));

                // adding to transaction list
                events.add(event);
            } while (c.moveToNext());
        }

        return events;
    }

    /**
     * getting evnets filtered by zip
     * */
    public List<Event> getEventsWithZip(String zip) {
        List<Event> events = new ArrayList<Event>();
        String selectQuery = "SELECT  * FROM " + TBL_EVENT  + " WHERE " + KEY_ZIP + " LIKE '" +  zip + "%" + "'";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Event event = new Event();
                event.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                event.set_title(c.getString(c.getColumnIndex(KEY_TITLE)));
                event.set_description(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
                event.set_date(c.getString(c.getColumnIndex(KEY_DATE)));
                event.set_zip(c.getString(c.getColumnIndex(KEY_ZIP)));
                event.set_person(c.getString(c.getColumnIndex(KEY_PERSON)));
                event.set_category(c.getString(c.getColumnIndex(KEY_CATEGORY)));

                // adding to transaction list
                events.add(event);
            } while (c.moveToNext());
        }

        return events;
    }

    /**
     * getting evnets filtered by category
     * */
    public List<Event> getEventsWithCategory(String category) {
        List<Event> events = new ArrayList<Event>();
        String selectQuery = "SELECT  * FROM " + TBL_EVENT + " WHERE " + KEY_CATEGORY +  " LIKE '" + category + "%" + "'";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Event event = new Event();
                event.set_id(c.getInt(c.getColumnIndex(KEY_ID)));
                event.set_title(c.getString(c.getColumnIndex(KEY_TITLE)));
                event.set_description(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
                event.set_date(c.getString(c.getColumnIndex(KEY_DATE)));
                event.set_zip(c.getString(c.getColumnIndex(KEY_ZIP)));
                event.set_person(c.getString(c.getColumnIndex(KEY_PERSON)));
                event.set_category(c.getString(c.getColumnIndex(KEY_CATEGORY)));

                // adding to transaction list
                events.add(event);
            } while (c.moveToNext());
        }

        return events;
    }

    /*
     * getting event count
     */
    public int getWishesCount() {
        String countQuery = "SELECT  * FROM " + TBL_EVENT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /*
     * Updating a event
     */
    public int updateEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, event.get_title());
        values.put(KEY_DESCRIPTION, event.get_description());
        values.put(KEY_DATE, event.get_date());
        values.put(KEY_ZIP, event.get_zip());
        values.put(KEY_PERSON, event.get_person());
        values.put(KEY_CATEGORY, event.get_category());

        // updating row
        return db.update(TBL_EVENT, values, KEY_ID + " = ?",
                new String[] { String.valueOf(event.get_id()) });
    }

    /*
     * Deleting a event
     */
    public void deleteEvent(int event_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TBL_EVENT, KEY_ID + " = ?",
                new String[] { String.valueOf(event_id) });
    }


}
