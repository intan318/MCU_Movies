package com.example.mcu_movies.Network;

import com.example.mcu_movies.Model.DataResponse;
import com.example.mcu_movies.Model.ErrorMessage;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("film")
    Call<DataResponse> getData();
    @FormUrlEncoded
    @POST("bunga")
    Call<ErrorMessage> addFilm (@Field("title_film") String title_film,
                                @Field("genre_film") String genre_film,
                                @Field("release_year") String release_year,
                                @Field("rating_film") String rating_film,
                                @Field("director_film") String director_film,
                                @Field("language_film") String language_film
    );

    @FormUrlEncoded
    @PUT("film/{id}")
    Call<ErrorMessage> editFilm (@Path("id") Integer id,
                                 @Field("title_film") String title_film,
                                 @Field("genre_film") String genre_film,
                                 @Field("release_year") String release_year,
                                 @Field("rating_film") String rating_film,
                                 @Field("director_film") String director_film,
                                 @Field("language_film") String language_film
    );

    @DELETE("film/{id}")
    Call<ErrorMessage> deleteFilm (@Path("id") Integer id);
}
