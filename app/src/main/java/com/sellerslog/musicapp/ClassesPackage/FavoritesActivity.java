package com.sellerslog.musicapp.ClassesPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.sellerslog.musicapp.AdaptersPackage.FavoritesCustomAdapter;
import com.sellerslog.musicapp.OthersPackage.ItemDecoration;
import com.sellerslog.musicapp.R;
import com.sellerslog.musicapp.OthersPackage.SongDBHelper;
import com.sellerslog.musicapp.ModelsPackage.SongModel;

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

    private void getData() {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorites:
                Intent intent = new Intent(FavoritesActivity.this, FavoritesActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
