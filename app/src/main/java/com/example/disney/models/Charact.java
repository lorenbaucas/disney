package com.example.disney.models;

public class Charact {

    //Esta clase la uso para poner solo los datos que quiero poner de cada personaje
    private String name;
    private int id;
    private String imageUrl;

    public Charact(String name, int id, String imageUrl) {
        this.name = name;
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}