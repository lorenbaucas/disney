package com.example.disney.controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.disney.adapter.RecyclerAdapter;
import com.example.disney.api.Methods;
import com.example.disney.models.Charact;
import com.example.disney.models.Model;
import com.example.disney.R;
import com.example.disney.api.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //Declaro la lista y los elementos del recycler view
    private RecyclerView recyclerView;
    private RecyclerAdapter recAdapter;

    private ArrayList<Charact> charactListFull = new ArrayList<>();
    private ArrayList<Charact> charactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dejo esto por si quiero que aparezca el action bar y le cambio el título y el color
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#80DEEA")));
        //getSupportActionBar().setTitle("Personajes Disney");

        //Oculto el action bar porque no me gusta
        getSupportActionBar().hide();

        //Con el Retrofit hago la llamada a la api
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<Model> call = methods.getAllData();

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                //Esto lo uso para ver si realmente consigue los datos de la api
                //Log.e("MainActivity", "onResponse: code: "+response.code());

                ArrayList<Model.data> data = response.body().getData();

                //Por el log veo los nombres de los personajes como ejemplo para comprobar que hace bien la llamada
                for (Model.data data1 : data) {
                    //Log.e("MainActivity", "onResponse: characters : " + data1.getName() + "  " + data1.getImageUrl());
                    //Añado a la lista solo los datos que necesito poner en el recylclerview
                    charactListFull.add(new Charact(data1.getName(), data1.get_id(), data1.getImageUrl()));
                }
                //Añado solo 10 personajes porque son demasiados y da error al cargarlos todos
                for (int i = 0; i < 11; i++) {
                    charactList.add(new Charact(charactListFull.get(i).getName(), charactListFull.get(i).getId(), charactListFull.get(i).getImageUrl()));
                    //Hago este sout para comprobar que se han añadido correctamente
                    //System.out.println(charactList.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                //Si la llamada a la api no se realiza correctamente podré ver el fallo
                //Log.e("MainActivity", "onFailure: "+ t.getMessage());
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recView);
        recyclerView.setAdapter(new RecyclerAdapter(charactList, MainActivity.this));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}