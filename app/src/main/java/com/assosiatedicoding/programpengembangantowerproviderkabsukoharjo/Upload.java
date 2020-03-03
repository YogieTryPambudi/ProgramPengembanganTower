package com.assosiatedicoding.programpengembangantowerproviderkabsukoharjo;

import com.google.firebase.database.Exclude;

public class Upload {
    private String nama;
    private String mImageUrl;
    private String mKey;
    private String deskripsi;
    private Double latitude;
    private Double longitude;

    private int position;


    public Upload() {
        //empty constructor needed
    }
    public Upload(int position){
        this.position = position;
    }


    public Upload(String name, String imageUrl, String description, Double Latitude, Double Longitude) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        nama = name;
        mImageUrl = imageUrl;
        deskripsi = description;
        latitude = Latitude;
        longitude = Longitude;

    }

    public String getName() {
        return nama;
    }

    public void setName(String name) {
        nama = name;
    }



    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
    public void setDescription(String description){
        deskripsi = description;
    }
    public String getDescription(){
        return deskripsi;
    }
    public void setLatitude(Double Latitude){
        latitude = Latitude;
    }
    public Double getLatitude(){
        return latitude;
    }
    public void setLongitude(Double Longitude){
        longitude = Longitude;
    }
    public Double getLongitude(){
        return longitude;
    }
    @Exclude
    public String getmKey(){
        return mKey;
    }
    @Exclude
    public void setmKey(String key){
        mKey = key;
    }
}


