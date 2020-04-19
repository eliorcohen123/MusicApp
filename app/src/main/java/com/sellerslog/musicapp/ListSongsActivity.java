package com.sellerslog.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

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
            aharei_kol_hashanim, katavti_alaih_shir, maim_shkufim, shigra_mefoeret, titen_la_prahim;
    private String song_data;
    private TextView biography;

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

        mSongList.clear();
        if (song_data.equals("1")) {
            biography.setText("אייל גולן נולד ב-12 באפריל 1971 הוא זמר ישראלי, מהזמרים המצליחים בישראל. הוא גם בעליו של מועדון הכדורגל הפועל מרמורק מרחובות.\n" +
                    "גולן נחשב פורץ דרך בתחומו, והיה הזמר הראשון מז'אנר המוזיקה המזרחית שזכה בתואר זמר השנה במצעד הפזמונים העברי השנתי של רשת ג'. שירו \"דמעות\" היה לשיר המזרחי הראשון, שזכה בתואר \"שיר השנה\". נוסף על אלו, גולן הוא הזמר המזרחי היחיד שזכה בתואר המקביל - במצעד הפזמונים השנתי של גלגלצ.\n");
            initAddSongs(mSongList, "חוזר הביתה", hozer_habaita, "אם רק היית יודעת", im_rak_haiit_yodaat,
                    "מכאן ועד הנצח", mikan_vead_haneztah, "עומד כאן לבדי", omed_kan_levadi, "שבוי לאהבה", shavui_laahava);
        } else if (song_data.equals("2")) {
            biography.setText("איתי לוי נולד ב25 בינואר 1988. \n" +
                    "איתי לוי נולד בגן יבנה וגדל בשכונת שעריים שברחובות. כשהיה בן 16, אביו נפטר מסרטן הריאות. \n" +
                    "אמו לקתה בארבעה אירועים מוחיים, שהותירו אותה מאז בעלת מוגבלות סיעודית.\n" +
                    "את שירותו בצה\"ל עשה כעובד רס\"ר בבית הספר לצניחה.\n");
            initAddSongs(mSongList, "המחשבות הורגות אותי", hamahshavot_horgot_oti, "השקט של שבת", hasheket_shel_shabbat,
                    "הולכת יחפה", holehet_yehefa, "לקחת את המפתחות", lakaht_et_hamaftehot, "תודה לך", toda_lah);
        } else if (song_data.equals("3")) {
            biography.setText("דודו אהרון נולד ב-23 בדצמבר 1984 הוא זמר-יוצר ישראלי.\n" +
                    "אהרון נחשב לאחד מן הזמרים הבולטים בישראל במוזיקה המזרחית החל מהעשור הראשון של המאה ה-21. הוא מוערך הן כזמר והן בזכות השירים שהוא כותב ומלחין לזמרים אחרים הנמנים עם ז'אנר המוזיקה הים-תיכונית. הוא הוציא את אלבומו הראשון \"אהבה ראשונה\" בשנת 2007, התפרסם במהרה וצבר קהל מעריצים גדול.\n");
            initAddSongs(mSongList, "הגורל הזה", hagoral_haze, "מבול", mabul,
                    "מזל מאזניים", mazal_moznaim, "שם טבעת עליה", sam_tabaat_aleiha, "טרמינל 3", terminal3);
        } else if (song_data.equals("4")) {
            biography.setText("ליאור ואנונו נרקיס נולד ב-8 בנובמבר 1976 הוא זמר ישראלי.\n" +
                    "בנובמבר 2009 נשא נרקיס לאישה את ספיר ואנונו, הצעירה ממנו ב-11 שנה. לזוג שני בנים ובת. הם מתגוררים בסביון.\n" +
                    "ליאור נרקיס נולד בחולון כבן זקונים לדוד וחנה נרקיס. \n" +
                    "נרקיס החל לשיר בגיל 16. בשנת 1994 הוציא את אלבומו הראשון, \"תפילת חיי\", שהיה אלבום עם לחנים טורקיים, וכלל בעיקר שירים בסגנון טורקי. \n" +
                    "מתוך האלבום התבלט השיר המצליח שהיה להיט גדול באותה תקופה, \"כמו פרפר\".\n");
            initAddSongs(mSongList, "אחי", ahi, "ערב טוב", erev_tov,
                    "אש", esh, "כמה אהבה", kama_ahava, "רק שלך", rak_shelah);
        } else if (song_data.equals("5")) {
            biography.setText("פרץ נולד ב10 במאי 1983 וגדל בטבריה. \n" +
                    "עוד בילדותו החל לשיר כפייטן בבית הכנסת \"יעקב גז\" בטבריה, הסמוך לבית הוריו. הוא התגייס לצה\"ל בנובמבר 2001 לחיל החימוש ולאחר מכן התקבל ללהקה צבאית. כאשר עלה לשיר את \"שיר למעלות\" בטקס יום הזיכרון לחללי מערכות ישראל שנערך בבסיסו, קיבל משובים חיוביים, וקצין החינוך סייע בידו לגשת לבחינות הקבלה ללהקה צבאית. ביולי 2002 הוא עבר את בחינות הקבלה בהצלחה והתקבל לצוות הווי פיקוד צפון, ובמקביל החל לעבוד על הפקת אלבום משלו.\n");
            initAddSongs(mSongList, "ברצלונה", barcelona, "קרמלה", karamela,
                    "לילה בסיני", layla_besinay, "סימני הזמן", simanei_hazman, "זיקוקים", zikukim);
        } else if (song_data.equals("6")) {
            biography.setText("נסרין ברכה קדרי נולדה ב-2 בספטמבר 1986 היא זמרת ערבייה-ישראלית, שהתגיירה. קדרי זוכת העונה השנייה של תוכנית המציאות המוזיקלית \"אייל גולן קורא לך\".\n" +
                    "קדרי נולדה למשפחה ערבית מוסלמית בלוד, וגדלה בחיפה.\n" +
                    "בשנת 2012 השתתפה קדרי בעונתה השנייה של תוכנית המציאות, \"אייל גולן קורא לך\" בערוץ 24, שם בין היתר ביצעה את השירים: \"לילות בבית\" (של זהבה בן), \"כשהלב בוכה\" (של שרית חדד), \"אהבה אסורה\" (של זהבה בן), וזכתה בה במקום הראשון.\n");
            initAddSongs(mSongList, "אלבי מעאק", albi_maak, "לומדת ללכת", lomedet_lalechet,
                    "לובשת חיוך", loveshet_hiuch, "תאמרו לו", tomru_lo, "יש לי אותך", yesh_li_otha);
        } else if (song_data.equals("7")) {
            biography.setText("עדן פסיה בן זקן (נולדה ב-8 ביוני 1994) היא זמרת ישראלית. התפרסמה בעקבות השתתפותה בעונתה הראשונה של תוכנית הטלוויזיה \"אקס פקטור ישראל\", בה הגיעה למקום השני. בן זקן הייתה גם שופטת אורחת בעונה השלישית.\n" +
                    "אלבומה הראשון, מלכת השושנים, קיבל מעמד של אלבום פלטינה כפולה וזיכה אותה בתואר \"זמרת השנה\" לשנת 2015, במצעד השנתי שנערך בשיתוף פעולה בין מאקו, ערוץ 24 ותחנות רדיו אזוריות. בשנת 2017, היא זכתה שוב בתואר, גם במצעד השנתי של רשת כאן גימל בקול ישראל וגם בתואר \"אשת השנה\" במצעד השנתי של גלגלצ לשנים תשע\"ז ותשע\"ח. בשנת 2018, זכתה במצעד השנתי של מאקו, בתואר \"זמרת השנה\", זו היא הפעם השלישית שבן זקן זוכה ברציפות.\n");
            initAddSongs(mSongList, "אגרוף", egrof, "ג'נטלמן", gentleman,
                    "חיים שלי", haim_sheli, "הזמן שלנו", hazman_shelanu, "כשתבוא", kshetavo);
        } else if (song_data.equals("8")) {
            biography.setText("עדן חסון נולד ב-1994 בפרדס חנה לאסתר, סייעת לגננת, וליורם, נהג משאית. גדל במשפחה דתית. בתקופת שירותו הצבאי שירת בבסיס חיל האוויר במצפה רמון, שם היה חלק מכיתת כוננות. את דרכו המוזיקלית החל בכתיבה ובהלחנה של שירים לזמרים כמו פאר טסי, עדן בן זקן ואיתי לוי.");
            initAddSongs(mSongList, "את חסרה לי", at_hasera_li, "אין יותר מועדונים", ein_yoter_moadonim,
                    "עיניים", einaim, "כפיות", kapiyot, "כשנגמרת הסופה", kshenigmeret_hasufa);
        } else if (song_data.equals("9")) {
            biography.setText("עומר אדם נולד ב22 באוקטובר 1993 בקרוליינה הצפונית שבארצות הברית בגיל שלוש חזר אדם עם משפחתו לישראל. התגורר במושב משמר השבעה עד 2017. בשנת 2005 השתתף בתחרות השירים \"שיר נולד\", כששר לצדו של טל מוסרי את השיר \"ילד פלא\".\n" +
                    "אביו, רס\"ן יניב אדם, שימש סגן מפקד יחידת שלדג וסמג\"ד של גדוד הצנחנים 202. בני משפחתו שמוצאה קווקזי מצד האב, ואשכנזי מצד אמו.\n");
            initAddSongs(mSongList, "אחרי כל השנים", aharei_kol_hashanim, "כתבתי עליך שיר", katavti_alaih_shir,
                    "מים שקופים", maim_shkufim, "שגרה מפוארת", shigra_mefoeret, "תתן לה פרחים", titen_la_prahim);
        } else if (song_data.equals("10")) {
            biography.setText("שרית חדד, נולדה ב-20 בספטמבר 1978 היא זמרת-יוצרת, מלחינה ומוזיקאית ישראלית, חדד נחשבת לאחת מהזמרות המצליחות והמשפיעות ביותר בישראל כאשר רבים משיריה היו ללהיטים וחלקם אף לנכסי צאן ברזל במוזיקה הישראלית (בניהם: \"הייתי בגן עדן\" ו\"כשהלב בוכה\"), היא פורצת דרך במוזיקה המזרחית, זכתה ארבע פעמים בתואר \"זמרת השנה\" וכמו כן, זכתה בתואר \"זמרת העשור\" בעשור הראשון של המאה ה-21. נציגת ישראל באירוויזיון 2002.\n");
            initAddSongs(mSongList, "את חסרה לי", at_hasera_li, "אין יותר מועדונים", ein_yoter_moadonim,
                    "עיניים", einaim, "כפיות", kapiyot, "כשנגמרת הסופה", kshenigmeret_hasufa);
        }
    }

    private void initAddSongs(ArrayList<SongModel> arrayListSong, String name1, MediaPlayer song1, String name2, MediaPlayer song2,
                              String name3, MediaPlayer song3, String name4, MediaPlayer song4, String name5, MediaPlayer song5) {
        arrayListSong.add(new SongModel(name1, song1));
        arrayListSong.add(new SongModel(name2, song2));
        arrayListSong.add(new SongModel(name3, song3));
        arrayListSong.add(new SongModel(name4, song4));
        arrayListSong.add(new SongModel(name5, song5));
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

}
