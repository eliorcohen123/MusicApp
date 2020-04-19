package com.sellerslog.musicapp;

import android.media.MediaPlayer;

import java.io.Serializable;

public class SongModel implements Serializable {

    private int id;
    private String songName;
    private String songImage;
    private MediaPlayer playSong;

    SongModel(String songName, MediaPlayer playSong) {
        this.songName = songName;
        this.playSong = playSong;
    }

    SongModel(int id, String songImage) {
        this.id = id;
        this.songImage = songImage;
    }

    SongModel(String songName) {
        this.songName = songName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongImage() {
        return songImage;
    }

    public void setSongImage(String songImage) {
        this.songImage = songImage;
    }

    public MediaPlayer getPlaySong() {
        return playSong;
    }

    public void setPlaySong(MediaPlayer playSong) {
        this.playSong = playSong;
    }

}
