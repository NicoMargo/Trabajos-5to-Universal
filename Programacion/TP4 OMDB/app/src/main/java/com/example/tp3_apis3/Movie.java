package com.example.tp3_apis3;

import java.util.Date;

public class Movie {


    //Basic Info
    private String _id;
    private String _title;
    private int _year;
    private String _poster;
    private String _type;
    //Details
    private String _rated;
    private String _releaseDate;
    private String _runTime;
    private String _genres;
    private String _director;
    private String _writers;
    private String _actors;
    private String _plot;
    private String _language;
    private String _country;
    private String _awards;
    private String _rating;
    private float _quantVotes;
    private String _studio;
    private String _website;

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

    public int get_year() {
        return _year;
    }

    public void set_year(int _year) {
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

    public String get_rated() {
        return _rated;
    }

    public void set_rated(String _rated) {
        this._rated = _rated;
    }

    public String get_releaseDate() {
        return _releaseDate;
    }

    public void set_releaseDate(String _releaseDate) {
        this._releaseDate = _releaseDate;
    }

    public String get_runTime() {
        return _runTime;
    }

    public void set_runTime(String _runTime) {
        this._runTime = _runTime;
    }

    public String get_genres() {
        return _genres;
    }

    public void set_genres(String _genres) {
        this._genres = _genres;
    }

    public String get_director() {
        return _director;
    }

    public void set_director(String _director) {
        this._director = _director;
    }

    public String get_writers() {
        return _writers;
    }

    public void set_writers(String _writers) {
        this._writers = _writers;
    }

    public String get_actors() {
        return _actors;
    }

    public void set_actors(String _actors) {
        this._actors = _actors;
    }

    public String get_plot() {
        return _plot;
    }

    public void set_plot(String _plot) {
        this._plot = _plot;
    }

    public String get_language() {
        return _language;
    }

    public void set_language(String _language) {
        this._language = _language;
    }

    public String get_country() {
        return _country;
    }

    public void set_country(String _country) {
        this._country = _country;
    }

    public String get_awards() {
        return _awards;
    }

    public void set_awards(String _awards) {
        this._awards = _awards;
    }

    public String get_rating() {
        return _rating;
    }

    public void set_rating(String _rating) {
        this._rating = _rating;
    }

    public float get_quantVotes() {
        return _quantVotes;
    }

    public void set_quantVotes(float _quantVotes) {
        this._quantVotes = _quantVotes;
    }

    public String get_studio() {
        return _studio;
    }

    public void set_studio(String _studio) {
        this._studio = _studio;
    }

    public String get_website() {
        return _website;
    }

    public void set_website(String _website) {
        this._website = _website;
    }

    public Movie(String title){
        _title = title;
    }

}
