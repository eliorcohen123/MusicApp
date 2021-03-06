package com.sellerslog.musicapp.AdaptersPackage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.sellerslog.musicapp.ActivitiesPackage.ListSongsActivity;
import com.sellerslog.musicapp.ModelsPackage.SongModel;
import com.sellerslog.musicapp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SingerCustomAdapter extends RecyclerView.Adapter<SingerCustomAdapter.CustomViewHolder> {

    private final Context context;
    private final List<SongModel> dataList;

    public SingerCustomAdapter(Context context, List<SongModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {

        private final View mView;
        private final ImageView image;
        private final LinearLayout linearLayout1;

        CustomViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            image = mView.findViewById(R.id.image);
            linearLayout1 = mView.findViewById(R.id.linear1);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.singer_item_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final SongModel current = dataList.get(position);
        Glide.with(context).load(current.getSongImage()).into(holder.image);

        holder.linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListSongsActivity.class);
                intent.putExtra(context.getString(R.string.song_data), String.valueOf(current.getId()));
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

}
