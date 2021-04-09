package com.sellerslog.musicapp.AdaptersPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sellerslog.musicapp.ModelsPackage.SongModel;
import com.sellerslog.musicapp.R;
import com.sellerslog.musicapp.OthersPackage.SongDBHelper;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class SongCustomAdapter extends RecyclerView.Adapter<SongCustomAdapter.CustomViewHolder> {

    private final Context context;
    private final List<SongModel> dataList;
    private SongDBHelper songDBHelper;

    public SongCustomAdapter(Context context, List<SongModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {

        private final View mView;
        private final TextView songName, singerName, duration;
        private final ImageView image, imagePlay, imageAdd;

        CustomViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            singerName = mView.findViewById(R.id.singerName);
            songName = mView.findViewById(R.id.songName);
            duration = mView.findViewById(R.id.duration);
            image = mView.findViewById(R.id.image);
            imagePlay = mView.findViewById(R.id.imagePlay);
            imageAdd = mView.findViewById(R.id.imageAdd);
        }
    }

    @NonNull
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
        final int seconds = (duration / 1000) % 60;
        final int minutes = ((duration / (1000 * 60)) % 60);
        final String secondsFinal;
        final String minutesFinal;
        if (seconds < 10) {
            secondsFinal = "0" + seconds;
        } else {
            secondsFinal = String.valueOf(seconds);
        }
        if (minutes < 10) {
            minutesFinal = "0" + minutes;
        } else {
            minutesFinal = String.valueOf(minutes);
        }

        holder.duration.setText(minutesFinal + ":" + secondsFinal);

        holder.imagePlay.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_play_arrow_white_24dp));

        holder.imagePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current.getPlaySong().isPlaying()) {
                    current.getPlaySong().pause();
                    holder.imagePlay.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_play_arrow_white_24dp));
                } else {
                    current.getPlaySong().start();
                    holder.imagePlay.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_stop_white_24dp));
                }
            }
        });

        holder.imageAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songDBHelper = new SongDBHelper(context);
                songDBHelper.addSong(current.getSingerName(), current.getSongName(), current.getSongImage(), minutesFinal + ":" + secondsFinal);
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

}
