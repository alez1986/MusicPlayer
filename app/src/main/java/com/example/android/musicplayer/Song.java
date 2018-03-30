package com.example.android.musicplayer;


public class Song {
    public Song(String singer, String title) {
        mSinger = singer;
        mTitle = title;
    };

    public String getSinger() {
        return mSinger;
    }
    public String getTitle() {
        return mTitle;
    }

    private String mSinger;
    private String mTitle;
}
