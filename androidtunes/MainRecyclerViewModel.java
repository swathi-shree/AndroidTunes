package com.music.androidtunes;

public class MainRecyclerViewModel {
    private int topCover;
    private String topName;

    public MainRecyclerViewModel(int topLogo, String topName){

        this.topCover = topLogo;
        this.topName = topName;
    }

    public int getTopCover() {
        return topCover;
    }

    public String getTopName() {
        return topName;
    }
}
