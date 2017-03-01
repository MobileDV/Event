package com.example.a5465465465.events.Model;

/**
 * Created by Administrator on 2/13/2017.
 */

public class Event {
    private int _id;
    private String _title;
    private String _description;
    private String _date;
    private String _zip;
    private String _person;
    private String _category;

    public Event() {

    }

    public Event(String title, String description, String date, String zip, String person, String category) {
        this._title = title;
        this._description = description;
        this._date = date;
        this._zip = zip;
        this._person = person;
        this._category = category;
    }

    public int get_id() {
        return _id;
    }

    public String get_title() {
        return _title;
    }

    public String get_description() {
        return _description;
    }

    public String get_date() {
        return _date;
    }

    public String get_zip() {
        return _zip;
    }

    public String get_person() {
        return _person;
    }

    public String get_category() {
        return _category;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public void set_zip(String _zip) {
        this._zip = _zip;
    }

    public void set_person(String _person) {
        this._person = _person;
    }

    public void set_category(String _category) {
        this._category = _category;
    }
}



