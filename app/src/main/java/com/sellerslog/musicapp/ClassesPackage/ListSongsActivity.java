package com.sellerslog.musicapp.ClassesPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.sellerslog.musicapp.OthersPackage.ItemDecoration;
import com.sellerslog.musicapp.R;
import com.sellerslog.musicapp.AdaptersPackage.SongCustomAdapter;
import com.sellerslog.musicapp.ModelsPackage.SongModel;

import java.util.ArrayList;

public class ListSongsActivity extends AppCompatActivity {

    private ArrayList<SongModel> mSongList = new ArrayList<>();
    private SongCustomAdapter mAdapter;
    private RecyclerView recyclerView;
    private ItemDecoration itemDecoration;
    private MediaPlayer hozer_habaita, im_rak_haiit_yodaat, mikan_vead_haneztah, omed_kan_levadi, shavui_laahava,
            hamahshavot_horgot_oti, hasheket_shel_shabbat, holehet_yehefa, lakaht_et_hamaftehot, toda_lah,
            hagoral_haze, mabul, mazal_moznaim, sam_tabaat_aleiha, terminal3,
            ahi, erev_tov, esh, kama_ahava, rak_shelah,
            barcelona, karamela, layla_besinay, simanei_hazman, zikukim,
            albi_maak, lomedet_lalechet, loveshet_hiuch, tomru_lo, yesh_li_otha,
            egrof, gentleman, haim_sheli, hazman_shelanu, kshetavo,
            at_hasera_li, ein_yoter_moadonim, einaim, kapiyot, kshenigmeret_hasufa,
            aharei_kol_hashanim, katavti_alaih_shir, maim_shkufim, shigra_mefoeret, titen_la_prahim,
            ata_totah, hofshia, lama_li, shev, shtei_dakot;
    private String song_data;
    private TextView biography;
    private String urlEyalGolan1 = "https://www.karaoke.co.il/prdPics/60393A_176428_plbclip_pic.jpg";
    private String urlEyalGolan2 = "https://i.ytimg.com/vi/F4M4jKzWBTI/hqdefault.jpg";
    private String urlEyalGolan3 = "https://upload.wikimedia.org/wikipedia/he/8/8f/%D7%9E%D7%9B%D7%90%D7%9F_%D7%95%D7%A2%D7%93_%D7%94%D7%A0%D7%A6%D7%97.png";
    private String urlEyalGolan4 = "https://i.ytimg.com/vi/CoH5kL1CgRA/maxresdefault.jpg";
    private String urlEyalGolan5 = "https://i.ytimg.com/vi/nER_3pjzzjg/maxresdefault.jpg";
    private String urlItayLevy1 = "https://i.ytimg.com/vi/SuCSVCkekK0/mqdefault.jpg";
    private String urlItayLevy2 = "https://www.karaoke.co.il/prdPics/info_60371A_111560_plbclip_pic.jpg";
    private String urlItayLevy3 = "https://yosmusic.com/wp-content/uploads/2020/03/299987-1024x1024.jpg";
    private String urlItayLevy4 = "https://upload.wikimedia.org/wikipedia/he/9/98/%D7%9C%D7%A7%D7%97%D7%AA_%D7%90%D7%AA_%D7%94%D7%9E%D7%A4%D7%AA%D7%97%D7%95%D7%AA.jpg";
    private String urlItayLevy5 = "https://i.ytimg.com/vi/Wv1Fj3WJh2A/hqdefault.jpg";
    private String urlDuduAharon1 = "https://i.ytimg.com/vi/cIrZTo31HNU/maxresdefault.jpg";
    private String urlDuduAharon2 = "https://yosmusic.com/wp-content/uploads/2020/01/%D7%93%D7%95%D7%93%D7%95-%D7%90%D7%94%D7%A8%D7%95%D7%9F-2020.jpg";
    private String urlDuduAharon3 = "https://i.ytimg.com/vi/UG-ciMacpVc/hqdefault.jpg";
    private String urlDuduAharon4 = "https://yosmusic.com/wp-content/uploads/2016/07/%D7%93%D7%95%D7%93%D7%95-%D7%90%D7%94%D7%A8%D7%95%D7%9F-%D7%A9%D7%9D-%D7%98%D7%91%D7%A2%D7%AA-%D7%A2%D7%9C%D7%99%D7%94.jpg";
    private String urlDuduAharon5 = "https://images.genius.com/78a7db82e2a305848b2d219c5ec2357d.1000x563x1.jpg";
    private String urlLiorNarkis1 = "https://img.youtube.com/vi/QbXheydfkww/0.jpg?resize=153%2C153";
    private String urlLiorNarkis2 = "https://i.ytimg.com/vi/ROprTrE8MKU/hqdefault.jpg";
    private String urlLiorNarkis3 = "https://i.ytimg.com/vi/LK_33zgRo5M/maxresdefault.jpg";
    private String urlLiorNarkis4 = "https://i.ytimg.com/vi/xIT-itrjgV4/maxresdefault.jpg";
    private String urlLiorNarkis5 = "https://i.ytimg.com/vi/DGDW6g_qgHw/maxresdefault.jpg";
    private String urlMoshePerezt1 = "https://i.ytimg.com/vi/Fc34DOzipUo/maxresdefault.jpg";
    private String urlMoshePerezt2 = "https://i.ytimg.com/vi/dMaUNdXs6-w/maxresdefault.jpg";
    private String urlMoshePerezt3 = "https://i.ytimg.com/vi/4VeOTlKE3Bs/maxresdefault.jpg";
    private String urlMoshePerezt4 = "https://i.ytimg.com/vi/WaO47gh0fVw/maxresdefault.jpg";
    private String urlMoshePerezt5 = "https://i.ytimg.com/vi/16H12jNP3x0/maxresdefault.jpg";
    private String urlNasrinKadri1 = "https://www.yamfm.co.il/wp-content/uploads/nasrin-0818-cover.jpg";
    private String urlNasrinKadri2 = "https://i.ytimg.com/vi/9z0ngP20Bd8/maxresdefault.jpg";
    private String urlNasrinKadri3 = "https://i.ytimg.com/vi/avwXrGSK9Yo/maxresdefault.jpg";
    private String urlNasrinKadri4 = "https://i.ytimg.com/vi/qUPDIbhuyRs/maxresdefault.jpg";
    private String urlNasrinKadri5 = "https://i.ytimg.com/vi/whvXmxrZlIQ/maxresdefault.jpg";
    private String urlEdenBenZaken1 = "https://i.ytimg.com/vi/IW9OvRwHPR4/maxresdefault.jpg";
    private String urlEdenBenZaken2 = "https://lh3.googleusercontent.com/proxy/zLmMiUqsAYFsGhIzand-q4NSJwuiI2PZXwe_gt-hT-CqBvAOvvcQ9w85scNQaKdqRISuC7J6og90Zq1BoaHIUpg0yOeSiysBmijwzNX9kNMJayZAoszTw3hHiYwIbMhYoEUFybSeal1Cte-N2iQjnVOOodU";
    private String urlEdenBenZaken3 = "https://i.ytimg.com/vi/qEEzKfGa1oY/maxresdefault.jpg";
    private String urlEdenBenZaken4 = "https://i.ytimg.com/vi/zd-PWczlWzA/maxresdefault.jpg";
    private String urlEdenBenZaken5 = "https://i.ytimg.com/vi/TQfSx6Qh71Q/maxresdefault.jpg";
    private String urlEdenHason1 = "https://i.ytimg.com/vi/PbHmqjolaa4/maxresdefault.jpg";
    private String urlEdenHason2 = "https://i.ytimg.com/vi/hySvIlHhCgA/maxresdefault.jpg";
    private String urlEdenHason3 = "https://i.ytimg.com/vi/1b_bhq0fFX0/maxresdefault.jpg";
    private String urlEdenHason4 = "https://i.ytimg.com/vi/pzAmYC7Xxtw/hqdefault.jpg";
    private String urlEdenHason5 = "https://i.ytimg.com/vi/Etdy_3Nojcg/maxresdefault.jpg";
    private String urlOmerAdam1 = "https://upload.wikimedia.org/wikipedia/he/thumb/0/09/%D7%90%D7%9C%D7%91%D7%95%D7%9D_%D7%90%D7%97%D7%A8%D7%99_%D7%9B%D7%9C_%D7%94%D7%A9%D7%A0%D7%99%D7%9D.jpg/250px-%D7%90%D7%9C%D7%91%D7%95%D7%9D_%D7%90%D7%97%D7%A8%D7%99_%D7%9B%D7%9C_%D7%94%D7%A9%D7%A0%D7%99%D7%9D.jpg";
    private String urlOmerAdam2 = "https://images.genius.com/b55b209339f799e809771acf9b4c73b6.1000x563x1.jpg";
    private String urlOmerAdam3 = "https://i.ytimg.com/vi/y-Ae0pPckVI/maxresdefault.jpg";
    private String urlOmerAdam4 = "https://i.ytimg.com/vi/qykAuMfwOw8/maxresdefault.jpg";
    private String urlOmerAdam5 = "https://i.ytimg.com/vi/mrFDtpqO19w/maxresdefault.jpg";
    private String urlSaritHadad1 = "https://lh3.googleusercontent.com/proxy/lUgspiiVnPxmGHXLwG36I4e1YleGWE61yd-PT13BtCyTg4PST3SqSv7FsXzJpCl-K87uQCJVUjrkncf55kocBfhlSOFhKofELc_qLFQ";
    private String urlSaritHadad2 = "https://lh3.googleusercontent.com/proxy/9Dj58ikiqjRx3Vvff5E9qjhF1jggqpkTe5uVmMPie5UQDMFOmzlJj_2XDHonT82yXSCWhP9NFjz1F_OoLfhJ6mFbnA7cLLxv4zAPaw";
    private String urlSaritHadad3 = "https://upload.wikimedia.org/wikipedia/he/e/ec/%D7%A9%D7%A8%D7%99%D7%AA-%D7%97%D7%93%D7%93-%D7%9C%D7%9E%D7%94-%D7%9C%D7%99.jpg";
    private String urlSaritHadad4 = "https://i.ytimg.com/vi/vPPNJahFCko/maxresdefault.jpg";
    private String urlSaritHadad5 = "https://i.ytimg.com/vi/xrN8UNCh0wQ/maxresdefault.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_songs);

        initUI();
        initSongs();
        initRV();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
        biography = findViewById(R.id.biography);

        song_data = getIntent().getStringExtra(getString(R.string.song_data)); // GetSerializable for the texts
    }

    private void initSongs() {
        // אייל גולן
        hozer_habaita = MediaPlayer.create(ListSongsActivity.this, R.raw.hozer_habaita);
        im_rak_haiit_yodaat = MediaPlayer.create(ListSongsActivity.this, R.raw.im_rak_haiit_yodaat);
        mikan_vead_haneztah = MediaPlayer.create(ListSongsActivity.this, R.raw.mikan_vead_haneztah);
        omed_kan_levadi = MediaPlayer.create(ListSongsActivity.this, R.raw.omed_kan_levadi);
        shavui_laahava = MediaPlayer.create(ListSongsActivity.this, R.raw.shavui_laahava);

        // איתי לוי
        hamahshavot_horgot_oti = MediaPlayer.create(ListSongsActivity.this, R.raw.hamahshavot_horgot_oti);
        hasheket_shel_shabbat = MediaPlayer.create(ListSongsActivity.this, R.raw.hasheket_shel_shabbat);
        holehet_yehefa = MediaPlayer.create(ListSongsActivity.this, R.raw.holehet_yehefa);
        lakaht_et_hamaftehot = MediaPlayer.create(ListSongsActivity.this, R.raw.lakaht_et_hamaftehot);
        toda_lah = MediaPlayer.create(ListSongsActivity.this, R.raw.toda_lah);

        // דודו אהרון
        hagoral_haze = MediaPlayer.create(ListSongsActivity.this, R.raw.hagoral_haze);
        mabul = MediaPlayer.create(ListSongsActivity.this, R.raw.mabul);
        mazal_moznaim = MediaPlayer.create(ListSongsActivity.this, R.raw.mazal_moznaim);
        sam_tabaat_aleiha = MediaPlayer.create(ListSongsActivity.this, R.raw.sam_tabaat_aleiha);
        terminal3 = MediaPlayer.create(ListSongsActivity.this, R.raw.terminal3);

        // ליאור נרקיס
        ahi = MediaPlayer.create(ListSongsActivity.this, R.raw.ahi);
        erev_tov = MediaPlayer.create(ListSongsActivity.this, R.raw.erev_tov);
        esh = MediaPlayer.create(ListSongsActivity.this, R.raw.esh);
        kama_ahava = MediaPlayer.create(ListSongsActivity.this, R.raw.kama_ahava);
        rak_shelah = MediaPlayer.create(ListSongsActivity.this, R.raw.rak_shelah);

        // משה פרץ
        barcelona = MediaPlayer.create(ListSongsActivity.this, R.raw.barcelona);
        karamela = MediaPlayer.create(ListSongsActivity.this, R.raw.karamela);
        layla_besinay = MediaPlayer.create(ListSongsActivity.this, R.raw.layla_besinay);
        simanei_hazman = MediaPlayer.create(ListSongsActivity.this, R.raw.simanei_hazman);
        zikukim = MediaPlayer.create(ListSongsActivity.this, R.raw.zikukim);

        // נסרין קדרי
        albi_maak = MediaPlayer.create(ListSongsActivity.this, R.raw.albi_maak);
        lomedet_lalechet = MediaPlayer.create(ListSongsActivity.this, R.raw.lomedet_lalechet);
        loveshet_hiuch = MediaPlayer.create(ListSongsActivity.this, R.raw.loveshet_hiuch);
        tomru_lo = MediaPlayer.create(ListSongsActivity.this, R.raw.tomru_lo);
        yesh_li_otha = MediaPlayer.create(ListSongsActivity.this, R.raw.yesh_li_otha);

        // עדן בן זקן
        egrof = MediaPlayer.create(ListSongsActivity.this, R.raw.egrof);
        gentleman = MediaPlayer.create(ListSongsActivity.this, R.raw.gentleman);
        haim_sheli = MediaPlayer.create(ListSongsActivity.this, R.raw.haim_sheli);
        hazman_shelanu = MediaPlayer.create(ListSongsActivity.this, R.raw.hazman_shelanu);
        kshetavo = MediaPlayer.create(ListSongsActivity.this, R.raw.kshetavo);

        // עדן חסון
        at_hasera_li = MediaPlayer.create(ListSongsActivity.this, R.raw.at_hasera_li);
        ein_yoter_moadonim = MediaPlayer.create(ListSongsActivity.this, R.raw.ein_yoter_moadonim);
        einaim = MediaPlayer.create(ListSongsActivity.this, R.raw.einaim);
        kapiyot = MediaPlayer.create(ListSongsActivity.this, R.raw.kapiyot);
        kshenigmeret_hasufa = MediaPlayer.create(ListSongsActivity.this, R.raw.kshenigmeret_hasufa);

        // עומר אדם
        aharei_kol_hashanim = MediaPlayer.create(ListSongsActivity.this, R.raw.aharei_kol_hashanim);
        katavti_alaih_shir = MediaPlayer.create(ListSongsActivity.this, R.raw.katavti_alaih_shir);
        maim_shkufim = MediaPlayer.create(ListSongsActivity.this, R.raw.maim_shkufim);
        shigra_mefoeret = MediaPlayer.create(ListSongsActivity.this, R.raw.shigra_mefoeret);
        titen_la_prahim = MediaPlayer.create(ListSongsActivity.this, R.raw.titen_la_prahim);

        // שרית חדד
        ata_totah = MediaPlayer.create(ListSongsActivity.this, R.raw.ata_totah);
        hofshia = MediaPlayer.create(ListSongsActivity.this, R.raw.hofshia);
        lama_li = MediaPlayer.create(ListSongsActivity.this, R.raw.lama_li);
        shev = MediaPlayer.create(ListSongsActivity.this, R.raw.shev);
        shtei_dakot = MediaPlayer.create(ListSongsActivity.this, R.raw.shtei_dakot);

        mSongList.clear();
        if (song_data.equals("1")) {
            biography.setText("אייל גולן נולד ב-12 באפריל 1971 הוא זמר ישראלי, מהזמרים המצליחים בישראל. הוא גם בעליו של מועדון הכדורגל הפועל מרמורק מרחובות.\n" +
                    "גולן נחשב פורץ דרך בתחומו, והיה הזמר הראשון מז'אנר המוזיקה המזרחית שזכה בתואר זמר השנה במצעד הפזמונים העברי השנתי של רשת ג'. שירו \"דמעות\" היה לשיר המזרחי הראשון, שזכה בתואר \"שיר השנה\". נוסף על אלו, גולן הוא הזמר המזרחי היחיד שזכה בתואר המקביל - במצעד הפזמונים השנתי של גלגלצ.\n");
            initAddSongs(mSongList, "אייל גולן", urlEyalGolan1, "חוזר הביתה", hozer_habaita, urlEyalGolan2, "אם רק היית יודעת", im_rak_haiit_yodaat,
                    urlEyalGolan3, "מכאן ועד הנצח", mikan_vead_haneztah, urlEyalGolan4, "עומד כאן לבדי", omed_kan_levadi, urlEyalGolan5, "שבוי לאהבה", shavui_laahava);
        } else if (song_data.equals("2")) {
            biography.setText("איתי לוי נולד ב25 בינואר 1988. \n" +
                    "איתי לוי נולד בגן יבנה וגדל בשכונת שעריים שברחובות. כשהיה בן 16, אביו נפטר מסרטן הריאות. \n" +
                    "אמו לקתה בארבעה אירועים מוחיים, שהותירו אותה מאז בעלת מוגבלות סיעודית.\n" +
                    "את שירותו בצה\"ל עשה כעובד רס\"ר בבית הספר לצניחה.\n");
            initAddSongs(mSongList, "איתי לוי", urlItayLevy1, "המחשבות הורגות אותי", hamahshavot_horgot_oti, urlItayLevy2, "השקט של שבת", hasheket_shel_shabbat,
                    urlItayLevy3, "הולכת יחפה", holehet_yehefa, urlItayLevy4, "לקחת את המפתחות", lakaht_et_hamaftehot, urlItayLevy5, "תודה לך", toda_lah);
        } else if (song_data.equals("3")) {
            biography.setText("דודו אהרון נולד ב-23 בדצמבר 1984 הוא זמר-יוצר ישראלי.\n" +
                    "אהרון נחשב לאחד מן הזמרים הבולטים בישראל במוזיקה המזרחית החל מהעשור הראשון של המאה ה-21. הוא מוערך הן כזמר והן בזכות השירים שהוא כותב ומלחין לזמרים אחרים הנמנים עם ז'אנר המוזיקה הים-תיכונית. הוא הוציא את אלבומו הראשון \"אהבה ראשונה\" בשנת 2007, התפרסם במהרה וצבר קהל מעריצים גדול.\n");
            initAddSongs(mSongList, "דודו אהרון", urlDuduAharon1, "הגורל הזה", hagoral_haze, urlDuduAharon2, "מבול", mabul,
                    urlDuduAharon3, "מזל מאזניים", mazal_moznaim, urlDuduAharon4, "שם טבעת עליה", sam_tabaat_aleiha, urlDuduAharon5, "טרמינל 3", terminal3);
        } else if (song_data.equals("4")) {
            biography.setText("ליאור ואנונו נרקיס נולד ב-8 בנובמבר 1976 הוא זמר ישראלי.\n" +
                    "בנובמבר 2009 נשא נרקיס לאישה את ספיר ואנונו, הצעירה ממנו ב-11 שנה. לזוג שני בנים ובת. הם מתגוררים בסביון.\n" +
                    "ליאור נרקיס נולד בחולון כבן זקונים לדוד וחנה נרקיס. \n" +
                    "נרקיס החל לשיר בגיל 16. בשנת 1994 הוציא את אלבומו הראשון, \"תפילת חיי\", שהיה אלבום עם לחנים טורקיים, וכלל בעיקר שירים בסגנון טורקי. \n" +
                    "מתוך האלבום התבלט השיר המצליח שהיה להיט גדול באותה תקופה, \"כמו פרפר\".\n");
            initAddSongs(mSongList, "ליאור נרקיס", urlLiorNarkis1, "אחי", ahi, urlLiorNarkis2, "ערב טוב", erev_tov,
                    urlLiorNarkis3, "אש", esh, urlLiorNarkis4, "כמה אהבה", kama_ahava, urlLiorNarkis5, "רק שלך", rak_shelah);
        } else if (song_data.equals("5")) {
            biography.setText("משה פרץ נולד ב10 במאי 1983 וגדל בטבריה. \n" +
                    "עוד בילדותו החל לשיר כפייטן בבית הכנסת \"יעקב גז\" בטבריה, הסמוך לבית הוריו. הוא התגייס לצה\"ל בנובמבר 2001 לחיל החימוש ולאחר מכן התקבל ללהקה צבאית. כאשר עלה לשיר את \"שיר למעלות\" בטקס יום הזיכרון לחללי מערכות ישראל שנערך בבסיסו, קיבל משובים חיוביים, וקצין החינוך סייע בידו לגשת לבחינות הקבלה ללהקה צבאית. ביולי 2002 הוא עבר את בחינות הקבלה בהצלחה והתקבל לצוות הווי פיקוד צפון, ובמקביל החל לעבוד על הפקת אלבום משלו.\n");
            initAddSongs(mSongList, "משה פרץ", urlMoshePerezt1, "ברצלונה", barcelona, urlMoshePerezt2, "קרמלה", karamela, urlMoshePerezt3, "לילה בסיני", layla_besinay, urlMoshePerezt4, "סימני הזמן", simanei_hazman, urlMoshePerezt5, "זיקוקים", zikukim);
        } else if (song_data.equals("6")) {
            biography.setText("נסרין ברכה קדרי נולדה ב-2 בספטמבר 1986 היא זמרת ערבייה-ישראלית, שהתגיירה. קדרי זוכת העונה השנייה של תוכנית המציאות המוזיקלית \"אייל גולן קורא לך\".\n" +
                    "קדרי נולדה למשפחה ערבית מוסלמית בלוד, וגדלה בחיפה.\n" +
                    "בשנת 2012 השתתפה קדרי בעונתה השנייה של תוכנית המציאות, \"אייל גולן קורא לך\" בערוץ 24, שם בין היתר ביצעה את השירים: \"לילות בבית\" (של זהבה בן), \"כשהלב בוכה\" (של שרית חדד), \"אהבה אסורה\" (של זהבה בן), וזכתה בה במקום הראשון.\n");
            initAddSongs(mSongList, "נסרין קדרי", urlNasrinKadri1, "אלבי מעאק", albi_maak, urlNasrinKadri2, "לומדת ללכת", lomedet_lalechet,
                    urlNasrinKadri3, "לובשת חיוך", loveshet_hiuch, urlNasrinKadri4, "תאמרו לו", tomru_lo, urlNasrinKadri5, "יש לי אותך", yesh_li_otha);
        } else if (song_data.equals("7")) {
            biography.setText("עדן פסיה בן זקן (נולדה ב-8 ביוני 1994) היא זמרת ישראלית. התפרסמה בעקבות השתתפותה בעונתה הראשונה של תוכנית הטלוויזיה \"אקס פקטור ישראל\", בה הגיעה למקום השני. בן זקן הייתה גם שופטת אורחת בעונה השלישית.\n" +
                    "אלבומה הראשון, מלכת השושנים, קיבל מעמד של אלבום פלטינה כפולה וזיכה אותה בתואר \"זמרת השנה\" לשנת 2015, במצעד השנתי שנערך בשיתוף פעולה בין מאקו, ערוץ 24 ותחנות רדיו אזוריות. בשנת 2017, היא זכתה שוב בתואר, גם במצעד השנתי של רשת כאן גימל בקול ישראל וגם בתואר \"אשת השנה\" במצעד השנתי של גלגלצ לשנים תשע\"ז ותשע\"ח. בשנת 2018, זכתה במצעד השנתי של מאקו, בתואר \"זמרת השנה\", זו היא הפעם השלישית שבן זקן זוכה ברציפות.\n");
            initAddSongs(mSongList, "עדן בן זקן", urlEdenBenZaken1, "אגרוף", egrof, urlEdenBenZaken2, "ג'נטלמן", gentleman,
                    urlEdenBenZaken3, "חיים שלי", haim_sheli, urlEdenBenZaken4, "הזמן שלנו", hazman_shelanu, urlEdenBenZaken5, "כשתבוא", kshetavo);
        } else if (song_data.equals("8")) {
            biography.setText("עדן חסון נולד ב-1994 בפרדס חנה לאסתר, סייעת לגננת, וליורם, נהג משאית. גדל במשפחה דתית. בתקופת שירותו הצבאי שירת בבסיס חיל האוויר במצפה רמון, שם היה חלק מכיתת כוננות. את דרכו המוזיקלית החל בכתיבה ובהלחנה של שירים לזמרים כמו פאר טסי, עדן בן זקן ואיתי לוי.");
            initAddSongs(mSongList, "עדן חסון", urlEdenHason1, "את חסרה לי", at_hasera_li, urlEdenHason2, "אין יותר מועדונים", ein_yoter_moadonim,
                    urlEdenHason3, "עיניים", einaim, urlEdenHason4, "כפיות", kapiyot, urlEdenHason5, "כשנגמרת הסופה", kshenigmeret_hasufa);
        } else if (song_data.equals("9")) {
            biography.setText("עומר אדם נולד ב22 באוקטובר 1993 בקרוליינה הצפונית שבארצות הברית בגיל שלוש חזר אדם עם משפחתו לישראל. התגורר במושב משמר השבעה עד 2017. בשנת 2005 השתתף בתחרות השירים \"שיר נולד\", כששר לצדו של טל מוסרי את השיר \"ילד פלא\".\n" +
                    "אביו, רס\"ן יניב אדם, שימש סגן מפקד יחידת שלדג וסמג\"ד של גדוד הצנחנים 202. בני משפחתו שמוצאה קווקזי מצד האב, ואשכנזי מצד אמו.\n");
            initAddSongs(mSongList, "עומר אדם", urlOmerAdam1, "אחרי כל השנים", aharei_kol_hashanim, urlOmerAdam2, "כתבתי עליך שיר", katavti_alaih_shir,
                    urlOmerAdam3, "מים שקופים", maim_shkufim, urlOmerAdam4, "שגרה מפוארת", shigra_mefoeret, urlOmerAdam5, "תתן לה פרחים", titen_la_prahim);
        } else if (song_data.equals("10")) {
            biography.setText("שרית חדד, נולדה ב-20 בספטמבר 1978 היא זמרת-יוצרת, מלחינה ומוזיקאית ישראלית, חדד נחשבת לאחת מהזמרות המצליחות והמשפיעות ביותר בישראל כאשר רבים משיריה היו ללהיטים וחלקם אף לנכסי צאן ברזל במוזיקה הישראלית (בניהם: \"הייתי בגן עדן\" ו\"כשהלב בוכה\"), היא פורצת דרך במוזיקה המזרחית, זכתה ארבע פעמים בתואר \"זמרת השנה\" וכמו כן, זכתה בתואר \"זמרת העשור\" בעשור הראשון של המאה ה-21. נציגת ישראל באירוויזיון 2002.\n");
            initAddSongs(mSongList, "שרית חדד", urlSaritHadad1, "אתה תותח", ata_totah, urlSaritHadad2, "חופשיה", hofshia,
                    urlSaritHadad3, "למה לי", lama_li, urlSaritHadad4, "שב", shev, urlSaritHadad5, "שתי דקות", shtei_dakot);
        }
    }

    private void initAddSongs(ArrayList<SongModel> arrayListSong, String nameSinger, String url1, String name1, MediaPlayer song1,
                              String url2, String name2, MediaPlayer song2, String url3, String name3, MediaPlayer song3,
                              String url4, String name4, MediaPlayer song4, String url5, String name5, MediaPlayer song5) {
        arrayListSong.add(new SongModel(nameSinger, name1, url1, song1));
        arrayListSong.add(new SongModel(nameSinger, name2, url2, song2));
        arrayListSong.add(new SongModel(nameSinger, name3, url3, song3));
        arrayListSong.add(new SongModel(nameSinger, name4, url4, song4));
        arrayListSong.add(new SongModel(nameSinger, name5, url5, song5));
    }

    private void initRV() {
        mAdapter = new SongCustomAdapter(this, mSongList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (itemDecoration == null) {
            itemDecoration = new ItemDecoration(20);
            recyclerView.addItemDecoration(itemDecoration);
        }
        recyclerView.setAdapter(mAdapter);
    }

    private void stopMusic() {
        for (int i = 0; i < mSongList.size(); i++) {
            if (mSongList.get(i).getPlaySong().isPlaying()) {
                mSongList.get(i).getPlaySong().pause();
            }
        }
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
            case R.id.favorites:
                Intent intent = new Intent(ListSongsActivity.this, FavoritesActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();

        stopMusic();
    }

    @Override
    protected void onStop() {
        super.onStop();

        stopMusic();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        stopMusic();
    }

}
