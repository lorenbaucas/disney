package com.example.disney.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //Creo un retrofit con la url base de la api
    private static Retrofit retrofit;
    private static String BASE_URL = "https://api.disneyapi.dev/";

    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    //Con esto consigo leer el json
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
