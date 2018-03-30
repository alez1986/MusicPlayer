package com.example.android.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;


public class SongDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_song);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.details_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        ImageView image = (ImageView) findViewById(R.id.song_icon);
        image.setMaxHeight(height / 4);

        TextView artistText = (TextView) findViewById(R.id.artist);
        artistText.setText(getIntent().getStringExtra("artist"));
        TextView songText = (TextView) findViewById(R.id.title);
        songText.setText(getIntent().getStringExtra("title"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
