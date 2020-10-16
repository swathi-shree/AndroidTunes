package com.music.androidtunes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.music.androidtunes.R;
import com.music.androidtunes.models.ElectronicProvider;
import com.music.androidtunes.models.Song;
import com.music.androidtunes.models.HipHopProvider;
import com.music.androidtunes.models.PopProvider;
import com.music.androidtunes.models.SongAdapter;


import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    public static final String SONG_DETAIL_KEY = "song";

    ListView SongList;
    SongAdapter songAdapter;
    ArrayList<Song> aSongs;

    // this function loops through providers to search for a good match for the query
    public ArrayList<Song> fetchSong(String query){
        ArrayList<Song> SongQuery = new ArrayList<Song>(); //an array list that would hold any query filtered songs
        ArrayList<Song> CheckQuery;// temp arraylist that will hold song objects of each provider

        /*the next 3 for loops; loops through the checkquery which will hold data from the corresponding provider
        Information about each song objects are checked against query to see if it matches.
        If the info matched then the song is stored inside SongQuery*/

        CheckQuery = PopProvider.generateData();
        for (int i = 0; i< CheckQuery.size(); i++){
            Song sample = CheckQuery.get(i);
            String name = sample.getName();
            String artist = sample.getArtist();
            String year = String.valueOf((sample.getYear()));
            if ((name.equalsIgnoreCase(query))||(artist.equalsIgnoreCase(query))||(year.equalsIgnoreCase(query))){
                SongQuery.add(sample);
            }
        }
        CheckQuery = HipHopProvider.generateData();
        for (int i = 0; i< CheckQuery.size(); i++){
            Song sample = CheckQuery.get(i);
            String name = sample.getName();
            String artist = sample.getArtist();
            String year = String.valueOf((sample.getYear()));
            if ((name.equalsIgnoreCase(query))||(artist.equalsIgnoreCase(query))||(year.equalsIgnoreCase(query))){
                SongQuery.add(sample);
            }
        }
        CheckQuery = ElectronicProvider.generateData();
        for (int i = 0; i< CheckQuery.size(); i++){
            Song sample = CheckQuery.get(i);
            String name = sample.getName();
            String artist = sample.getArtist();
            String year = String.valueOf((sample.getYear()));
            if ((name.equalsIgnoreCase(query))||(artist.equalsIgnoreCase(query))||(year.equalsIgnoreCase(query))){
                SongQuery.add(sample);
            }
        }
        //if the query doesn't match any songs then a not found message is outputted
        if (SongQuery.size() == 0){
            Toast.makeText(this, "Sorry cannot find what you're looking for", Toast.LENGTH_LONG).show();
        }

        return SongQuery;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        SongList = (ListView) findViewById(R.id.listView);
        aSongs = new ArrayList<Song>();


        if(MainActivity.QUERY_KEY != ""){
            ListActivity.this.setTitle(MainActivity.QUERY_KEY);
            songAdapter = new SongAdapter(this, fetchSong(MainActivity.QUERY_KEY));
            MainActivity.QUERY_KEY ="";
        }else {
            if (MainActivity.HOME_ACTIVITY_KEY == "Pop") {
                aSongs = PopProvider.generateData();
            } else if (MainActivity.HOME_ACTIVITY_KEY == "Hiphop") {
                aSongs = HipHopProvider.generateData();
            } else if (MainActivity.HOME_ACTIVITY_KEY == "Electronic") {
                aSongs = ElectronicProvider.generateData();
            }
            songAdapter = new SongAdapter(this, aSongs);
        }


        SongList.setAdapter(songAdapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);

        setupSongSelectedListener();

    }
    
    
    public void openAnotherActivity(View view) {
        Intent intent = new Intent(this, SongDetailsActivity.class);
        startActivity(intent);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void setupSongSelectedListener() {
        SongList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing song as an extra
                Intent detailsIntent = new Intent(ListActivity.this, SongDetailsActivity.class);
                detailsIntent.putExtra(SONG_DETAIL_KEY,(Song) songAdapter.getItem(position));
                startActivity(detailsIntent);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                // Reset SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();

//                fetchSong(query);
                MainActivity.QUERY_KEY = query;
                ListActivity.this.setTitle(MainActivity.QUERY_KEY);
                songAdapter = new SongAdapter(getBaseContext(), fetchSong(query));
                MainActivity.QUERY_KEY ="";

                SongList.setAdapter(songAdapter);
                LinearLayoutManager lm = new LinearLayoutManager(getBaseContext());
                setupSongSelectedListener();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }
}
