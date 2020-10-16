package com.music.androidtunes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.music.androidtunes.R;
import com.music.androidtunes.models.ElectronicProvider;
import com.music.androidtunes.models.HipHopProvider;
import com.music.androidtunes.models.PopProvider;
import com.music.androidtunes.models.Song;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // initialise variable

    RecyclerView recyclerView;

    ArrayList<MainRecyclerViewModel> mainModels;
    ArrayList<Song> topPop, topHip, topElectric, topSong;
    MainAdapter mainAdapter;

    public static String HOME_ACTIVITY_KEY = "";
    public static String QUERY_KEY = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView popMusic = findViewById(R.id.pop_music);
        CardView HiphopMusic = findViewById(R.id.hip_pop_music);
        CardView electricMusic = findViewById(R.id.electric_music);

        popMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(getBaseContext(), ListActivity.class);
                HOME_ACTIVITY_KEY = "Pop";
                startActivity(searchIntent);
            }
        });
        HiphopMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(getBaseContext(), ListActivity.class);
                HOME_ACTIVITY_KEY = "Hiphop";
                startActivity(searchIntent);
            }
        });
        electricMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(getBaseContext(), ListActivity.class);
                HOME_ACTIVITY_KEY = "Electronic";
                startActivity(searchIntent);
            }
        });

        // Assign Variable
        recyclerView = findViewById(R.id.recycler_view);

        topPop = PopProvider.getrandom();
        topHip = HipHopProvider.getrandom();
        topElectric = ElectronicProvider.getrandom();
        topSong = new ArrayList<Song>();
        for (int j = 0; j<2;j++){
            topSong.add(topPop.get(j));
            topSong.add(topHip.get(j));
            topSong.add(topElectric.get(j));
        }

        mainModels = new ArrayList<MainRecyclerViewModel>();
        for(int i=0;i<topSong.size();i++){
            Song aSong = topSong.get(i);
            MainRecyclerViewModel model = new MainRecyclerViewModel(aSong.getCover(),aSong.getName());
            mainModels.add(model);
        }

           //design horizontal layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //initialise main adapter
        mainAdapter = new MainAdapter(MainActivity.this,topSong);
        //set MainAdapter to RecyclerView

        recyclerView.setAdapter(mainAdapter);


    }
    
     public void openNextActivity(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
                QUERY_KEY = query;
                Intent searchIntent = new Intent(getBaseContext(), ListActivity.class);
                startActivity(searchIntent);

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
