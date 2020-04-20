package com.sellerslog.musicapp.ClassesPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.sellerslog.musicapp.OthersPackage.ItemDecoration;
import com.sellerslog.musicapp.R;
import com.sellerslog.musicapp.AdaptersPackage.SingerCustomAdapter;
import com.sellerslog.musicapp.ModelsPackage.SongModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String urlEyalGolan = "https://radio-idan.co.il/wp-content/uploads/2019/02/258413.jpg";
    private String urlItayLevy = "https://i1.sndcdn.com/artworks-000323808416-m6zm58-t500x500.jpg";
    private String urlDuduAharon = "https://s3.amazonaws.com/helicon-cnaan/2018/wp-content/uploads/2018/01/01094339/DUDU801.jpg";
    private String urlLiorNarkis = "https://www.kfar-saba.muni.il/_uploads/extraimg/lior-nrkis(1).jpg";
    private String urlMoshePerezt = "https://grayclub.co.il/wp-content/uploads/2016/12/%D7%9E%D7%A9%D7%94-%D7%A4%D7%A8%D7%A5-1.png";
    private String urlNasrinKadri = "https://www.srugim.co.il/wp-content/uploads/2019/01/238056.jpg";
    private String urlEdenBenZaken = "https://lists.forbes.co.il/2018under30/files/2018/02/%D7%A2%D7%93%D7%9F-%D7%91%D7%9F-%D7%96%D7%A7%D7%9F-%D7%A6%D7%99%D7%9C%D7%95%D7%9D-%D7%98%D7%9C-%D7%A2%D7%91%D7%95%D7%93%D7%99.jpg";
    private String urlEdenHason = "https://www.zappa-club.co.il/download/showPic/show_pic3973_img.jpg";
    private String urlOmerAdam = "https://medias.timeout.co.il/www/uploads/2019/06/%D7%A2%D7%95%D7%9E%D7%A8-%D7%90%D7%93%D7%9D-%D7%A6%D7%99%D7%9C%D7%95%D7%9D-%D7%A8%D7%9E%D7%99-%D7%96%D7%A8%D7%A0%D7%92%D7%A8-1-Large-600x600-1559827037.jpg";
    private String urlSaritHadad = "https://is5-ssl.mzstatic.com/image/thumb/Features71/v4/33/5e/65/335e65b3-7dae-00db-7124-c1ed85af80b7/mzl.xmxwdxpv.jpg/800x800bb.jpeg";
    private ArrayList<SongModel> mSongList = new ArrayList<>();
    private SingerCustomAdapter mAdapter;
    private RecyclerView recyclerView;
    private ItemDecoration itemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initRV();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void initRV() {
        mSongList.add(new SongModel(1, urlEyalGolan));
        mSongList.add(new SongModel(2, urlItayLevy));
        mSongList.add(new SongModel(3, urlDuduAharon));
        mSongList.add(new SongModel(4, urlLiorNarkis));
        mSongList.add(new SongModel(5, urlMoshePerezt));
        mSongList.add(new SongModel(6, urlNasrinKadri));
        mSongList.add(new SongModel(7, urlEdenBenZaken));
        mSongList.add(new SongModel(8, urlEdenHason));
        mSongList.add(new SongModel(9, urlOmerAdam));
        mSongList.add(new SongModel(10, urlSaritHadad));
        mAdapter = new SingerCustomAdapter(this, mSongList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (itemDecoration == null) {
            itemDecoration = new ItemDecoration(20);
            recyclerView.addItemDecoration(itemDecoration);
        }
        recyclerView.setAdapter(mAdapter);
    }

    // Sets off the menu of activity_menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Options in the activity_menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.options:  // Mute all the sound in app
                Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
