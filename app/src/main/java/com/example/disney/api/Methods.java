package com.example.disney.api;

import com.example.disney.models.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {
    //Llamada para pedir los datos de la api
    @GET("characters?page=1")
    Call<Model> getAllData();
}
