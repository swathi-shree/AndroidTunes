package com.music.androidtunes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.music.androidtunes.R;
import com.music.androidtunes.models.Song;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

//    ArrayList<MainRecyclerViewModel> mainModels;
    ArrayList<Song> topSong;
    Context context;

    public MainAdapter(Context context, ArrayList<Song> topSong){
        this.context = context;
//        this.mainModels = mainModels;
        this.topSong = topSong;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //create view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        //set logo to imageview
//        holder.imageView.setImageResource(mainModels.get(position).getTopCover());
        holder.imageView.setImageResource((topSong.get(position)).getCover());


        //set name to textview
//        holder.textView.setText(mainModels.get(position).getTopName());
        holder.textView.setText((topSong.get(position)).getName());

        // set onClickListener
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create Intent
                Intent intent = new Intent(context,SongDetailsActivity.class);
//                intent.putExtra(ListActivity.SONG_DETAIL_KEY,(Song)topSong.get(position));
                intent.putExtra(ListActivity.SONG_DETAIL_KEY, (Song) topSong.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return topSong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //initialise variables
        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //assign variable
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
            linearLayout = itemView.findViewById(R.id.LinearLayout);
        }
    }
}
