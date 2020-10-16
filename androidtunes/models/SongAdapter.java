package com.music.androidtunes.models;
import com.music.androidtunes.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends ArrayAdapter {

    private static class ViewHolder{

        public ImageView songCover;
        public TextView songName;
        public TextView songArtist;

    }


    public SongAdapter(@NonNull Context context, ArrayList<Song> aSongs) {
        super(context, 0, aSongs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Song song = (Song) getItem(position);

        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.song_list_view_item,parent,false);
            viewHolder.songCover = (ImageView)convertView.findViewById(R.id.cover_icon_list);
            viewHolder.songName = (TextView)convertView.findViewById(R.id.song_name_list);
            viewHolder.songArtist = (TextView)convertView.findViewById(R.id.song_artist_name_list);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Populate the data into the template view using the data object
        viewHolder.songName.setText(song.getName());
        viewHolder.songArtist.setText(song.getArtist());

        int resID = song.getCover();

        viewHolder.songCover.setImageResource(resID);

        return convertView;
    }
}
