package com.sellerslog.musicapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaPlayer;
import android.util.Log;

import java.util.ArrayList;

public class SongDBHelper extends SQLiteOpenHelper {

    private static final String SONG_TABLE_NAME = "SONG";
    private static final String SONG_ID = "ID";
    private static final String SONG_NAME = "SONG_NAME";
    private Context ctx;

    public SongDBHelper(Context context) {
        super(context, SONG_TABLE_NAME, null, 1);

        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + SONG_TABLE_NAME + "(" +
                SONG_ID + " INTEGER PRIMARY KEY, " +
                SONG_NAME + " TEXT " + ")";
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

    public void addSong(String songName) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SONG_NAME, songName);

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

    public ArrayList<SongModel> getAllSongs() {
        ArrayList<SongModel> songModels = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(SONG_TABLE_NAME, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int colID = cursor.getColumnIndex(SONG_ID);
            int id = cursor.getInt(colID);
            String songName = cursor.getString(1);
            SongModel songModel = new SongModel(songName);
            songModel.setId(id);
            songModels.add(songModel);
        }
        cursor.close();
        return songModels;
    }

}
