package com.sellerslog.musicapp;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener  {

        private View mView;
        private TextView songName;
        private LinearLayout linearLayout1;

        CustomViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            songName = mView.findViewById(R.id.songName);
            linearLayout1 = mView.findViewById(R.id.linear1);

            mView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("בחר פעולה");
            MenuItem add = menu.add(Menu.NONE, 1, 1, "הוספה למועדפים");

            add.setOnMenuItemClickListener(onChange);
        }

        private final MenuItem.OnMenuItemClickListener onChange = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                SongModel current = dataList.get(getAdapterPosition());
                switch (item.getItemId()) {
                    case 1:
                        songDBHelper = new SongDBHelper(context);
                        songDBHelper.addSong(String.valueOf(current.getSongName()));
                        Intent intent = new Intent(context, FavoritesActivity.class);
                        context.startActivity(intent);
                        break;
                }
                return false;
            }
        };
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.song_item_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final SongModel current = dataList.get(position);
        holder.songName.setText(current.getSongName());

        holder.linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current.getPlaySong().start();
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
