package com.example.mcu_movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mcu_movies.Model.ErrorMessage;
import com.example.mcu_movies.Network.APIInterface;
import com.example.mcu_movies.Network.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class addFilm extends AppCompatActivity {
    private static final String TAG = "Add Data";
    private APIInterface apiInterface;

    EditText etFilmTitle, etFilmGenre, etReleaseYear, etFilmRating, etFilmDirector, etFilmLanguage;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        initData();
        btnAdd.setOnClickListener(view -> {
            Call<ErrorMessage> dataCall = apiInterface.addFilm(etFilmTitle.getText().toString(), etFilmGenre.getText().toString(), etReleaseYear.getText().toString(), etFilmRating.getText().toString(), etFilmDirector.getText().toString(), etFilmLanguage.getText().toString());
            dataCall.enqueue(new Callback<ErrorMessage>() {
                @Override
                public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {
                    Toast.makeText(addFilm.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onResponse: " + response.raw());
                    onBackPressed();
                }

                @Override
                public void onFailure(Call<ErrorMessage> call, Throwable t) {

                }
            });
        });

    }

    private void initData() {
        etFilmTitle = findViewById(R.id.editMovieTitle);
        etFilmGenre = findViewById(R.id.editMovieGenre);
        etReleaseYear = findViewById(R.id.editReleaseYear);
        etFilmRating = findViewById(R.id.editMovieRating);
        etFilmDirector = findViewById(R.id.editMovieDirector);
        etFilmLanguage = findViewById(R.id.editMovieLanguage);
        btnAdd = findViewById(R.id.btnAdd);
        apiInterface = APIService.getClient().create(APIInterface.class);
    }

    public void addData(String filmTitle, String filmGenre, String releaseYear, String filmRating, String filmDirector, String filmLanguage){
        Call<ErrorMessage> dataCall = apiInterface.addFilm(filmTitle, filmGenre, releaseYear, filmRating, filmDirector, filmLanguage);
        dataCall.enqueue(new Callback<ErrorMessage>() {
            @Override
            public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {

            }

            @Override
            public void onFailure(Call<ErrorMessage> call, Throwable t) {

            }
        });
}
}
