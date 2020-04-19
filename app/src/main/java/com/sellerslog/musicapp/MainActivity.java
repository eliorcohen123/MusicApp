package com.sellerslog.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String urlEyalGolan = "https://lyricstranslate.com/files/styles/large/public/e.png?itok=ronhi-d-";
    private String urlItayLevy = "https://images.eventer.co.il/metadataImages/a8f8f114-2a56-424a-8c2d-0c7d01849c56.png";
    private String urlDuduAharon = "https://banner.b-hnews.co.il/wp-content/uploads/2018/07/%D7%93%D7%95%D7%93%D7%95-%D7%90%D7%94%D7%A8%D7%95%D7%9F-%D7%A6%D7%9C%D7%9D-%D7%90%D7%95%D7%94%D7%93-%D7%A7%D7%91-e1532872714332.png";
    private String urlLiorNarkis = "https://lh3.googleusercontent.com/proxy/qmYp3jwdLtenMFfmYAwMbsDkchalMgg0P_JCmx9-GgG91aT95EgmCaTvHbIHEouBp4HyE5iCApy-VJ3K21JzZRO5D1pYMjBrO0S57Pq6kZntWDYSzCYgFrdWHTIu-LFJxG8RubZCbQ";
    private String urlMoshePerezt = "https://grayclub.co.il/wp-content/uploads/2016/12/%D7%9E%D7%A9%D7%94-%D7%A4%D7%A8%D7%A5-2.png";
    private String urlNasrinKadri = "https://lh3.googleusercontent.com/proxy/IOGHgHVZdImpZHW95pAk3sjDHlkerHJtOU0gABsjQ9SyITkKKeeE1H1WVE-ZiRdXofBvxf9ss-vzNCugd5ia8DmrJ_PSafBYLC264VMuWa38x4tcFnZNGLk8CWkYgIvjUtOH9gc";
    private String urlEdenBenZaken = "https://lh3.googleusercontent.com/proxy/hVGaIA3fLcMBieZooeEe45SUxLdzx6R78UkCTvnAcEn_iUAFXvy_5kCFQhqGfSkWbAqhfa7GpOK7gvqdI67JhFGoBo9Ux_D4LiV7RLrPf1J79tucznpOc7W7c0cuyHi5F20D4Xg";
    private String urlEdenHason = "https://www.israelhayom.co.il/sites/default/files/u55081/FADIDA_0.jpg";
    private String urlOmerAdam = "https://4.bp.blogspot.com/-bzucw8eTPEw/WBcDIdf_UoI/AAAAAAAAAv8/jmZv0qNSx3A-jXo-ES67yxPUk2RatQe3wCLcB/s1600/pic-7.jpg-750x420-1473576374.png";
    private String urlSaritHadad = "https://lh3.googleusercontent.com/proxy/r1JzzNgQVrvZJ6LOCIyAdgefhAT_ZleoIgMcAQSIxsme-wgxZ6bdGGMeKqendBwafK1doKT815aepSCMyt1kNo7tagGyx8Qv28vIf01e2aKUdJLcftiXtaRBsA-gF0_wIKj1vAL4";
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

}
