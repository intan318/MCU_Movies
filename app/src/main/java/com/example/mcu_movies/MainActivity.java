package com.example.mcu_movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.mcu_movies.Model.DataResponse;
import com.example.mcu_movies.Model.Film;
import com.example.mcu_movies.Network.APIInterface;
import com.example.mcu_movies.Network.APIService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private APIInterface apiInterface;
    private List<Film> dataList = new ArrayList<>();
    private RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter();

    FloatingActionButton btnFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rcyMovieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerViewAdapter);
        apiInterface = APIService.getClient().create(APIInterface.class);
        btnFloat = findViewById(R.id.btnFloat);


        btnFloat.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, addFilm.class)));

        recyclerViewAdapter.setOnClickListener(position -> {
            Film data = dataList.get(position);
            Intent intent = new Intent(MainActivity.this, UpdateData.class);
            intent.putExtra("film_title", data.getTitle_film());
            intent.putExtra("film_genre", String.valueOf(data.getGenre_film()));
            intent.putExtra("release_year", String.valueOf(data.getRelease_year()));
            intent.putExtra("film_rating", String.valueOf(data.getRating_film()));
            intent.putExtra("film_director", String.valueOf(data.getDirector_film()));
            intent.putExtra("film_language", String.valueOf(data.getLanguage_film()));
            intent.putExtra("id", data.getId());
            Log.d(TAG, "onCreate: " + data.getId());
            startActivity(intent);
        });
        getItem();
    }

    private void getItem() {
        Call<DataResponse> dataCall = apiInterface.getData();
        dataCall.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                List<Film> items = response.body().getData();
                recyclerViewAdapter.setDataList(items);
                dataList.addAll(items);
                Log.d(TAG, "onResponse: gg " + dataList);
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerViewAdapter.clearDataList(dataList);
        getItem();
    }
}