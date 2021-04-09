package com.sellerslog.musicapp.AdaptersPackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sellerslog.musicapp.ModelsPackage.SongModel;
import com.sellerslog.musicapp.OthersPackage.SongDBHelper;
import com.sellerslog.musicapp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritesCustomAdapter extends RecyclerView.Adapter<FavoritesCustomAdapter.CustomViewHolder> {

    private final Context context;
    private final List<SongModel> dataList;
    private SongDBHelper songDBHelper;
    private final FavoritesCustomAdapter favoritesCustomAdapter;

    public FavoritesCustomAdapter(Context context, List<SongModel> dataList) {
        this.context = context;
        this.dataList = dataList;
        this.favoritesCustomAdapter = this;
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {

        private final View mView;
        private final TextView songName, singerName, duration;
        private final ImageView image, imageDel, imageYouTube;

        CustomViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            singerName = mView.findViewById(R.id.singerName);
            songName = mView.findViewById(R.id.songName);
            duration = mView.findViewById(R.id.duration);
            image = mView.findViewById(R.id.image);
            imageDel = mView.findViewById(R.id.imageDel);
            imageYouTube = mView.findViewById(R.id.imageYouTube);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.song_item_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        final SongModel current = dataList.get(position);
        holder.songName.setText(current.getSongName());
        holder.singerName.setText(current.getSingerName());
        holder.duration.setText(current.getSongTime());
        Glide.with(context).load(current.getSongImage()).into(holder.image);

        holder.imageYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FavoritesCustomAdapter.this.watchYoutubeVideo(current.getSongName());
                } catch (Exception e) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.google.android.youtube"));
                    context.startActivity(intent);
                }
            }
        });

        holder.imageDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songDBHelper = new SongDBHelper(context);
                songDBHelper.deleteSong(current);

                dataList.remove(position);
                favoritesCustomAdapter.notifyItemRemoved(position);
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

    private void watchYoutubeVideo(String nameQuery) {
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.setPackage("com.google.android.youtube");
        intent.putExtra("query", nameQuery);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
