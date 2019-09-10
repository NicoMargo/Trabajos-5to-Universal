package com.example.tp4omdb2;

import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Movie {


    //Basic Info
    private String _id;
    private String _title;
    private String _year;
    private String _poster;
    private String _type;
    //Details
    private Map<String,String> _details = new HashMap<String,String>();

    private String[] MapKeys = {
        "Rated",
        "Released",
        "Runtime",
        "Genre",
        "Director",
        "Writer",
        "Actors",
        "Plot",
        "Language",
        "Country",
        "Awards",
        "imdbRating",
        "imdbVotes",
        "Production",
        "Website"
    };

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_year() {
        return _year;
    }

    public void set_year(String _year) {
        this._year = _year;
    }

    public String get_poster() {
        return _poster;
    }

    public void set_poster(String _poster) {
        this._poster = _poster;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public Movie(String title, String year,String id, String type, String poster){
        _title = title;
        _year = year;
        _id = id;
        _type = type;
        _poster = poster;
    }

}
