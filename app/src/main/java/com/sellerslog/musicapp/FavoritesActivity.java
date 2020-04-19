package com.sellerslog.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    private ArrayList<SongModel> mSongList = new ArrayList<>();
    private FavoritesCustomAdapter mAdapter;
    private RecyclerView recyclerView;
    private ItemDecoration itemDecoration;
    private SongDBHelper mSongDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        initUI();
        initRV();
        getData();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);

        mSongDBHelper = new SongDBHelper(this);
    }

    private void initRV() {
        mAdapter = new FavoritesCustomAdapter(this, mSongList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (itemDecoration == null) {
            itemDecoration = new ItemDecoration(20);
            recyclerView.addItemDecoration(itemDecoration);
        }
        recyclerView.setAdapter(mAdapter);
    }

    // This method is to fetch all user records from SQLite
    private void getData() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                mSongList.clear();
                mSongList.addAll(mSongDBHelper.getAllSongs());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                mAdapter.notifyDataSetChanged();
            }
        }.execute();
    }

}
