package com.music.androidtunes.models;

import java.io.Serializable;

public class Song implements Serializable {

    private String name, artist;
    private int CoverAddr, year;
    private Integer [] sliderImage;


    public Song (String name, String artist, int CoverAddr,int year, Integer[]sliderimages) {
        this.name = name;
        this.artist = artist;
        this.CoverAddr = CoverAddr;
        this.year = year;
        this.sliderImage = sliderimages;
    }

    public String getName() { return name; }

    public String getArtist() { return artist; }

    public int getCover() { return CoverAddr; }

    public int getYear() { return year; }

    public Integer[] getSliderImage(){ return sliderImage; }
}


