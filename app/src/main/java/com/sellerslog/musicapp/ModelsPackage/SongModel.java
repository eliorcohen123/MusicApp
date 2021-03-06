package com.sellerslog.musicapp.ModelsPackage;

import android.media.MediaPlayer;

import java.io.Serializable;

public class SongModel implements Serializable {

    private int id;
    private String songName;
    private String songImage;
    private String singerName;
    private String songTime;
    private MediaPlayer playSong;

    public SongModel(String singerName, String songName, String songImage, MediaPlayer playSong) {
        this.singerName = singerName;
        this.songName = songName;
        this.songImage = songImage;
        this.playSong = playSong;
    }

    public SongModel(String singerName, String songName, String songImage, String songTime) {
        this.singerName = singerName;
        this.songName = songName;
        this.songImage = songImage;
        this.songTime = songTime;
    }

    public SongModel(int id, String songImage) {
        this.id = id;
        this.songImage = songImage;
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

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongTime() {
        return songTime;
    }

    public void setSongTime(String songTime) {
        this.songTime = songTime;
    }

}
