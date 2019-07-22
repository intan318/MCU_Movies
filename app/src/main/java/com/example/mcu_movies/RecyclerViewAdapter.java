package com.example.mcu_movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mcu_movies.Model.Film;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Film> dataList = new ArrayList<>();
    private onViewClick listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_movies,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Film data = dataList.get(position);
        holder.txtTitleFilm.setText(data.getTitle_film());
        holder.txtGenreFilm.setText(data.getGenre_film());
        holder.txtReleaseYear.setText(data.getRelease_year());
        holder.txtRatingFilm.setText(data.getRating_film());
        holder.txtDirectorFilm.setText(data.getDirector_film());
        holder.txtLanguageFilm.setText(data.getLanguage_film());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitleFilm, txtGenreFilm, txtReleaseYear, txtRatingFilm, txtDirectorFilm, txtLanguageFilm;

        public ViewHolder(View itemView){
            super(itemView);
            txtTitleFilm = itemView.findViewById(R.id.movieTitle);
            txtGenreFilm = itemView.findViewById(R.id.movieGenre);
            txtReleaseYear = itemView.findViewById(R.id.releaseYear);
            txtRatingFilm = itemView.findViewById(R.id.movieRating);
            txtDirectorFilm = itemView.findViewById(R.id.movieDirector);
            txtLanguageFilm = itemView.findViewById(R.id.movieLanguage);

            itemView.setOnClickListener(view -> listener.onViewClick(getAdapterPosition()));
        }

    }

    public void setDataList(List<Film> list ){
        this.dataList = list;
        notifyDataSetChanged();
    }

    public void clearDataList(List<Film> list ){
        this.dataList = list;
        dataList.clear();
    }

    public interface onViewClick{
        void onViewClick(int position);
    }

    public void setOnClickListener(onViewClick listener){
        this.listener = listener;

    }


}
