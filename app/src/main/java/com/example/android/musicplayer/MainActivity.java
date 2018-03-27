package com.example.android.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.musicplayer.SongAdapter.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ArrayList<Song> words = new ArrayList<Song>();
        words.add(new Song("Britney Spears", "Work Bitch"));
        words.add(new Song("Madonna", "Frozen"));
        words.add(new Song("Depeche Mode", "Free Love"));
        words.add(new Song("Robbie Williams", "Freedom"));
        words.add(new Song("ABBA", "Mama Mia"));
        words.add(new Song("Betta Lemme", "Bambola"));
        words.add(new Song("Jacob Groening", "Haidi"));
        words.add(new Song("Alice Merton", "No Roots"));
        words.add(new Song("Lana Del Rey", "West Coast"));
        words.add(new Song("Beyonce", "Yonce"));

        SongAdapter itemsAdapter = new SongAdapter(this, words);
        ListView songList = (ListView) findViewById(R.id.list);
        songList.setAdapter(itemsAdapter);

        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent songDetails = new Intent(MainActivity.this, SongDetailsActivity.class);
                startActivity(songDetails);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            Intent searchSong = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(searchSong);

            Toast.makeText(MainActivity.this, "Search clicked", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
