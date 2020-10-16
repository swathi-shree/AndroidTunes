package com.music.androidtunes.models;
import com.music.androidtunes.R;
import com.music.androidtunes.models.Song;

import java.util.ArrayList;
import java.util.List;

public class PopProvider {


    static String[] names = {"Havana", "Blinding Lights", "Adore You", "Say So", "bad guy",
            "Falling", "Memories", "Watermelon Sugar", "Shape of You", "Sucker"

    };

    static String[] artists = {"Camila Cabelo", "The Weeknd", "Harry Styles", "Doja Cat", "Billie Eilish",
            "Trevor Daniel", "Maroon 5", "Harry Styles", "Ed Sheeran", "Jonas Brothers"

    };

    static int[] CoverAddrs = {R.drawable.havana, R.drawable.blinding, R.drawable.adore, R.drawable.say,
            R.drawable.badg, R.drawable.falling, R.drawable.memories, R.drawable.watermelon, R.drawable.shape,
            R.drawable.sucker
    };

    static int[] SliderCover = {R.drawable.havana1, R.drawable.havana2, R.drawable.havana3, R.drawable.blinding1,
            R.drawable.blinding2, R.drawable.blinding3, R.drawable.adoreyou1, R.drawable.adoreyou2, R.drawable.adoreyou3,
            R.drawable.say1, R.drawable.say2, R.drawable.say3, R.drawable.badguy1, R.drawable.badguy2, R.drawable.badguy3,
            R.drawable.falling1, R.drawable.falling2, R.drawable.falling3, R.drawable.memories1,
            R.drawable.memories2, R.drawable.memories3, R.drawable.watermelon1, R.drawable.watermelon2, R.drawable.watermelon3,
            R.drawable.shape1, R.drawable.shape2, R.drawable.shape3, R.drawable.sucker1, R.drawable.sucker2, R.drawable.sucker3

    };


    static int[] years = {2017, 2019, 2019, 2019, 2019, 2018, 2019, 2020,
            2017, 2019
    };


    public static ArrayList<Song> generateData() {
        ArrayList<Song> songs = new ArrayList<Song>();


        for (int i = 0; i < 10; i++) {

            // String id = ids[i];
            Integer[] sliderimages = new Integer[3];
            String name = names[i];
            String artist = artists[i];
            int CoverAddr = CoverAddrs[i];
            int year = years[i];

            int pos = ((i + 1) * 3) - 1;
            for (int j = 2; j > -1; j--) {
                sliderimages[j] = SliderCover[pos];
                pos = pos - 1;
            }

            Song aSong = new Song(name, artist, CoverAddr, year, sliderimages);
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


