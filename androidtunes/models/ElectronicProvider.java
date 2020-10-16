package com.music.androidtunes.models;
import com.music.androidtunes.R;
import com.music.androidtunes.models.Song;

import java.util.ArrayList;

public class ElectronicProvider {


    static String [] names = { "Wake Me Up", "Solo", "Happier", "Faded", "Taki Taki",
            "Feels","It Ain't Me", "Something Just Like This","Let Me Go","Know No Better"

    };

    static String [] artists = {"Avicii","Clean Bandit","Marshmello","Alan Walker","DJ Snake",
            "Calvin Harris","Kygo","Coldplay","Hailee Steinfeld","Major Lazer"

    };

    static int [] CoverAddrs = {R.drawable.wakemeup, R.drawable.solo,R.drawable.happier,R.drawable.faded,
            R.drawable.takitaki,R.drawable.feels,R.drawable.itaintme,R.drawable.somethingjustlikethis,R.drawable.letmego,
            R.drawable.knownobetter
    };
    static int [] SliderCover = {R.drawable.wake1, R.drawable.wake2,R.drawable.wake3, R.drawable.solo1,
            R.drawable.solo2,R.drawable.solo3,R.drawable.happier1,R.drawable.happier2,R.drawable.happier3,
            R.drawable.faded1,R.drawable.faded2,R.drawable.faded3, R.drawable.taki1,R.drawable.taki2,R.drawable.taki3,
            R.drawable.feels1,R.drawable.feels2,R.drawable.feels3,R.drawable.it1,R.drawable.it2,
            R.drawable.it3, R.drawable.something1,R.drawable.something2,R.drawable.something3,R.drawable.let1,
            R.drawable.let2,R.drawable.let3,R.drawable.know1,R.drawable.know2,R.drawable.know3
    };



    static int[] years = {2013, 2018, 2018, 2015, 2018, 2017, 2017, 2017,
            2017, 2017
    };

    public static ArrayList<Song> generateData() {
        ArrayList<Song> songs = new ArrayList<Song>();


        for (int i = 0; i < 10; i++) {

            Integer []sliderimages= new Integer[3];
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
