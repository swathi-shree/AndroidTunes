package com.music.androidtunes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.music.androidtunes.ListActivity;
import com.music.androidtunes.R;
import com.music.androidtunes.models.Song;

import java.util.ArrayList;


public class SongDetailsActivity extends AppCompatActivity {

    public static Integer [] SliderImg;
    ViewPager viewPager;


    private ImageView songCover;
    private TextView songTitle;
    private TextView songArtist;
    private TextView songYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);
        // Fetch views

        songCover = (ImageView) findViewById(R.id.coverimage);
        songTitle = (TextView) findViewById(R.id.title);
        songArtist = (TextView) findViewById(R.id.artist);
        songYear = (TextView) findViewById(R.id.year);

        Intent thisIntent = getIntent();
        // Use the song to populate the data into our views
        Song song = (Song) thisIntent.getSerializableExtra(ListActivity.SONG_DETAIL_KEY);
        SliderImg = song.getSliderImage();

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPageAdapter viewPagerAdapter = new ViewPageAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        loadSong(song);


    }

    private void loadSong(Song song) {
        //change activity title

        this.setTitle(song.getName());
        songTitle.setText(song.getName());
        songArtist.setText(song.getArtist());
        songYear.setText(Integer.toString(song.getYear()));

//        int mDrawableName = song.getCover();
        //int resID = getResources().getIdentifier(String.valueOf(mDrawableName), "drawable", getPackageName());
        int resID = song.getCover();
        songCover.setImageResource(resID);

    }
}
