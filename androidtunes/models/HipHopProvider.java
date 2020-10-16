package com.music.androidtunes.models;

import com.music.androidtunes.R;
import com.music.androidtunes.models.Song;

import java.util.ArrayList;

public class HipHopProvider {


    static String[] names = {"I Like It", "Middle Child", "Highest in the Room", "Humble", "See You Again",
            "One Dance", "T-Shirt", "Gucci Gang", "Moonlight", "Believe It"

    };

    static String[] artists = {"Cardi B", "J.Cole", "Travis Scott", "Kendrick Lamar", "Tyler,The Creator",
            "Drake", "Migos", "Lil Pump", "XXXTentacion", "Rihanna"

    };

    static int[] CoverAddrs = {R.drawable.ilikeit, R.drawable.middlechild, R.drawable.highestinroom, R.drawable.humble,
            R.drawable.seeyouagain, R.drawable.onedance, R.drawable.tshirt, R.drawable.guccigang, R.drawable.moonlight,
            R.drawable.believeit

    };
    static int [] SliderCover = {R.drawable.ilike1, R.drawable.ilike2,R.drawable.ilike3, R.drawable.middlechild1,
            R.drawable.middlechild2,R.drawable.middlechild3,R.drawable.highest1,R.drawable.highest2,R.drawable.highest3,
            R.drawable.humble1,R.drawable.humble2,R.drawable.humble3, R.drawable.see1,R.drawable.see2,R.drawable.see3,
            R.drawable.one1,R.drawable.one2,R.drawable.one3,R.drawable.tshirt1,R.drawable.tshirt2,
            R.drawable.tshirt3, R.drawable.gucci1,R.drawable.gucci2,R.drawable.gucci3,R.drawable.moon1,
            R.drawable.moon2,R.drawable.moon3,R.drawable.believe1,R.drawable.believe2,R.drawable.believe3
    };

    static int[] years = {2018, 2019, 2019, 2017, 2017, 2016, 2017, 2017,
            2018, 2020
    };


    public static ArrayList<Song> generateData() {
        ArrayList<Song> songs = new ArrayList<Song>();


        for (int i = 0; i < 10; i++) {

            Integer []sliderimages = new Integer[3];
            String name = names[i];
            String artist = artists[i];
            int CoverAddr = CoverAddrs[i];
            int year = years[i];
            int pos = ((i + 1) * 3)-1;
            for (int j = 2; j > -1; j--) {
                sliderimages[j] = SliderCover[pos];
                pos = pos - 1;
            }

            Song aSong = new Song(name,artist,CoverAddr,year,sliderimages);
            songs.add(aSong);
        }
        return songs;
    }

    public static ArrayList<Song>getrandom() {
        ArrayList<Song> randsong = new ArrayList<Song>();
        int min = 0;
        int max = 9;

        for (int i = 0; i < 2; i++) {
            int random = (int)(Math.random() * (max-min+1)+ min);

            // String id = ids[i];
            Integer[] sliderimages = new Integer[3];
            String name = names[random];
            String artist = artists[random];
            int CoverAddr = CoverAddrs[random];
            int year = years[random];
            int pos = ((random + 1) * 3) - 1;
            for (int j = 2; j > -1; j--) {
                sliderimages[j] = SliderCover[pos];
                pos = pos - 1;
            }

            Song aSong = new Song(name, artist, CoverAddr, year, sliderimages);
            randsong.add(aSong);
        }

        return randsong;
    }


}
