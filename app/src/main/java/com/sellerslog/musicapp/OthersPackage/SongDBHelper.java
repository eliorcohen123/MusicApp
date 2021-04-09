package com.sellerslog.musicapp.OthersPackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.sellerslog.musicapp.ModelsPackage.SongModel;

import java.util.ArrayList;

public class SongDBHelper extends SQLiteOpenHelper {

    private static final String SONG_TABLE_NAME = "SONG";
    private static final String SONG_ID = "ID";
    private static final String SINGER_NAME = "SINGER_NAME";
    private static final String SONG_NAME = "SONG_NAME";
    private static final String SONG_TIME = "SONG_TIME";
    private static final String SONG_IMAGE = "SONG_IMAGE";
    private final Context ctx;

    public SongDBHelper(Context context) {
        super(context, SONG_TABLE_NAME, null, 1);

        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + SONG_TABLE_NAME + "(" +
                SONG_ID + " INTEGER PRIMARY KEY, " +
                SINGER_NAME + " TEXT, " +
                SONG_NAME + " TEXT, " +
                SONG_IMAGE + " TEXT, " +
                SONG_TIME + " TEXT " + ")";
        try {
            db.execSQL(CREATE_TABLE);
        } catch (SQLiteException ex) {
            Log.e("SQLiteException", ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SONG_TABLE_NAME);
        onCreate(db);
    }

    public void addSong(String singerName, String songName, String songImage, String timeSong) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor1;
        cursor1 = db.rawQuery("SELECT * FROM " + SONG_TABLE_NAME + " WHERE " + SONG_NAME + "=?", new String[]{songName});
        if (cursor1.getCount() > 0) {
            Toast.makeText(ctx, "השיר נוסף כבר למועדפים", Toast.LENGTH_LONG).show();
        } else {
            contentValues.put(SINGER_NAME, singerName);
            contentValues.put(SONG_NAME, songName);
            contentValues.put(SONG_IMAGE, songImage);
            contentValues.put(SONG_TIME, timeSong);

            long id = db.insertOrThrow(SONG_TABLE_NAME, null, contentValues);
            try {
                Log.d("SongDBHelper", "insert new song with id: " + id +
                        ", Name: " + songName);
            } catch (SQLiteException ex) {
                Log.e("SongDBHelper", ex.getMessage());
            } finally {
                db.close();
            }
        }

        cursor1.close();
    }

    public void deleteSong(SongModel song) {
        SQLiteDatabase db = getWritableDatabase();

        String[] ids = new String[1];
        ids[0] = song.getId() + "";
        try {
            db.delete(SONG_TABLE_NAME, SONG_ID + " =? ", ids);
        } catch (SQLiteException e) {
            Log.e("SongDBHelper", e.getMessage());
        } finally {
            db.close();
        }
    }

    public ArrayList<SongModel> getAllSongs() {
        ArrayList<SongModel> songModels = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(SONG_TABLE_NAME, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int colID = cursor.getColumnIndex(SONG_ID);
            int id = cursor.getInt(colID);
            String singerName = cursor.getString(1);
            String songName = cursor.getString(2);
            String songImage = cursor.getString(3);
            String songTime = cursor.getString(4);
            SongModel songModel = new SongModel(singerName, songName, songImage, songTime);
            songModel.setId(id);
            songModels.add(songModel);
        }

        cursor.close();

        return songModels;
    }

}
