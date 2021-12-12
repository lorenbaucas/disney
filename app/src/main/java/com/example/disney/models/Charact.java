package com.example.disney.models;

public class Charact {

    //Esta clase la uso para poner solo los datos que quiero poner de cada personaje
    private String name;
    private String sourceUrl;
    private String imageUrl;

    public Charact(String name, String sourceUrl, String imageUrl) {
        this.name = name;
        this.sourceUrl = sourceUrl;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}