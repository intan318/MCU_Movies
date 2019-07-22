package com.example.mcu_movies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateData extends AppCompatActivity {
    private static final String TAG = "Tambah Data";
    private APIInterface apiInterface;

    EditText etFilmTitle, etFilmGenre, etReleaseYear, etFilmRating, etFilmDirector, etFilmLanguage;
    Button btnAdd;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        Intent intent = getIntent();

        etFilmTitle = findViewById(R.id.editMovieTitle);
        etFilmGenre = findViewById(R.id.editMovieGenre);
        etReleaseYear = findViewById(R.id.editReleaseYear);
        etFilmRating = findViewById(R.id.editMovieRating);
        etFilmDirector = findViewById(R.id.editMovieDirector);
        etFilmLanguage = findViewById(R.id.editMovieLanguage);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);

        String filmTitle = intent.getStringExtra("film_title");
        String filmGenre = intent.getStringExtra("film_genre");
        String releaseYear = intent.getStringExtra("release_year");
        String filmRating = intent.getStringExtra("film_rating");
        String filmDirector = intent.getStringExtra("film_director");
        String filmLanguage = intent.getStringExtra("filmLanguage");
        int id = intent.getIntExtra("id", 0);

        Log.d(TAG, "onCreate: gg " + intent.getStringExtra("film_title"));
        Log.d(TAG, "onCreate: " + id);

        etFilmTitle.setText(filmTitle);
        etFilmGenre.setText(filmGenre);
        etReleaseYear.setText(releaseYear);
        etFilmRating.setText(filmRating);
        etFilmDirector.setText(filmDirector);
        etFilmLanguage.setText(filmLanguage);
        apiInterface = APIService.getClient().create(APIInterface.class);
        btnAdd.setOnClickListener(view -> updateData(id, etFilmTitle.getText().toString(), id, (etFilmGenre.getText().toString()), (etReleaseYear.getText().toString()), (etFilmRating.getText().toString()), (etFilmDirector.getText().toString()), (etFilmLanguage.getText().toString())));

        btnDelete.setOnClickListener(view -> deleteData(id) );

    }

    private void updateData(int i, String id, int filmTitle, String filmGenre, String releaseYear, String ratingFilm, String filmDirector, String filmLanguage){
        Call<ErrorMessage> dataCall = apiInterface.editFilm(id, filmTitle, filmGenre, releaseYear, ratingFilm, filmDirector, filmLanguage);
        dataCall.enqueue(new Callback<ErrorMessage>() {
            @Override
            public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {
                Toast.makeText(UpdateData.this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: " + response.raw());
                onBackPressed();
            }
            @Override
            public void onFailure(Call<ErrorMessage> call, Throwable t) {
                Toast.makeText(UpdateData.this, "Data gagal diupdate", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ", t);
            }


        });



    }
    private void deleteData(int id){
        Call<ErrorMessage> data = apiInterface.deleteFilm(id);
        data.enqueue(new Callback<ErrorMessage>() {
            @Override
            public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {
                Toast.makeText(UpdateData.this, "Data Berhasil dihapus", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: jj " + response.raw());
            }

            @Override
            public void onFailure(Call<ErrorMessage> call, Throwable t) {
                Toast.makeText(UpdateData.this, "Data gagal dihapus", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure: jj ", t);
            }
        });
    }

}
