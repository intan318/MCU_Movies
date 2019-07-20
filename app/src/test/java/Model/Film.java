package Model;

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
}
