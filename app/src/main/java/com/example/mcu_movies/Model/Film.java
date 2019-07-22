package com.example.mcu_movies.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Film {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("title_film")
    @Expose
    private String title_film;

    @SerializedName("genre_film")
    @Expose
    private String genre_film;

    @SerializedName("release_year")
    @Expose
    private String release_year;

    @SerializedName("rating_film")
    @Expose
    private String rating_film;

    @SerializedName("director_film")
    @Expose
    private String director_film;

    @SerializedName("language_film")
    @Expose
    private String language_film;

    public Film (Integer id, String title_film, String genre_film, String release_year,
                 String rating_film, String director_film, String language_film){
        this.id = id;
        this.title_film = title_film;
        this.genre_film = genre_film;
        this.release_year = release_year;
        this.rating_film = rating_film;
        this.director_film = director_film;
        this.language_film = language_film;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle_film() {
        return title_film;
    }

    public void setTitle_film(String title_film) {
        this.title_film = title_film;
    }

    public String getGenre_film() {
        return genre_film;
    }

    public void setGenre_film(String genre_film) {
        this.genre_film = genre_film;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getRating_film() {
        return rating_film;
    }

    public void setRating_film(String rating_film) {
        this.rating_film = rating_film;
    }

    public String getDirector_film() {
        return director_film;
    }

    public void setDirector_film(String director_film) {
        this.director_film = director_film;
    }

    public String getLanguage_film() {
        return language_film;
    }

    public void setLanguage_film(String language_film) {
        this.language_film = language_film;
    }
}
