package com.example.mcu_movies.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("data")
    @Expose
    private List<Film> data = null;

    public List<Film> getData(){
        return data;
    }

    public void setData(List<Film> data){
        this.data = data;
    }
}
