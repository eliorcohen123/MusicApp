package com.sellerslog.musicapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class SongCustomAdapter extends RecyclerView.Adapter<SongCustomAdapter.CustomViewHolder> {

    private Context context;
    private List<SongModel> dataList;
    private SongDBHelper songDBHelper;

    public SongCustomAdapter(Context context, List<SongModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private TextView songName, singerName, duration;
        private ImageView image, imagePlay, imageAdd;
        private LinearLayout linearLayout1;

        CustomViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            singerName = mView.findViewById(R.id.singerName);
            songName = mView.findViewById(R.id.songName);
            duration = mView.findViewById(R.id.duration);
            image = mView.findViewById(R.id.image);
            imagePlay = mView.findViewById(R.id.imagePlay);
            imageAdd = mView.findViewById(R.id.imageAdd);
            linearLayout1 = mView.findViewById(R.id.linear1);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.song_item_row_play, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
        final SongModel current = dataList.get(position);
        holder.songName.setText(current.getSongName());
        holder.singerName.setText(current.getSingerName());
        Glide.with(context).load(current.getSongImage()).into(holder.image);

        int duration = current.getPlaySong().getDuration();
        int seconds = (int) (duration / 1000) % 60;
        int minutes = (int) ((duration / (1000 * 60)) % 60);
        holder.duration.setText(minutes + ":" + seconds);

        holder.imagePlay.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_play_arrow_white_24dp));

        holder.imagePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current.getPlaySong().isPlaying()) {
                    current.getPlaySong().pause();
                    holder.imagePlay.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_play_arrow_white_24dp));
                } else {
                    current.getPlaySong().start();
                    holder.imagePlay.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_stop_white_24dp));
                }
            }
        });

        holder.imageAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songDBHelper = new SongDBHelper(context);
                songDBHelper.addSong(current.getSingerName(), current.getSongName(), current.getSongImage());

                stopMusic();

                Intent intent = new Intent(context, FavoritesActivity.class);
                context.startActivity(intent);
            }
        });

        setFadeAnimation(holder.mView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1500);
        view.startAnimation(anim);
    }

    private void stopMusic() {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getPlaySong().isPlaying()) {
                dataList.get(i).getPlaySong().pause();
            }
        }
    }

}
