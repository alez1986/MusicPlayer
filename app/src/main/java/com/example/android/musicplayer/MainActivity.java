package com.example.android.musicplayer;

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


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ArrayList<Song> songArrayList = new ArrayList<Song>();
        songArrayList.add(new Song("Britney Spears", "Work Bitch"));
        songArrayList.add(new Song("Madonna", "Frozen"));
        songArrayList.add(new Song("Depeche Mode", "Free Love"));
        songArrayList.add(new Song("Robbie Williams", "Freedom"));
        songArrayList.add(new Song("ABBA", "Mama Mia"));
        songArrayList.add(new Song("Betta Lemme", "Bambola"));
        songArrayList.add(new Song("Jacob Groening", "Haidi"));
        songArrayList.add(new Song("Alice Merton", "No Roots"));
        songArrayList.add(new Song("Lana Del Rey", "West Coast"));
        songArrayList.add(new Song("Beyonce", "Yonce"));

        SongAdapter itemsAdapter = new SongAdapter(this, songArrayList);
        ListView songList = (ListView) findViewById(R.id.list);
        songList.setAdapter(itemsAdapter);

        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent songDetails = new Intent(MainActivity.this, SongDetailsActivity.class);
                TextView artistText = (TextView) view.findViewById(R.id.artist);
                TextView songText = (TextView) view.findViewById(R.id.title);

                songDetails.putExtra("artist", artistText.getText());
                songDetails.putExtra("title", songText.getText());

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

            Toast.makeText(MainActivity.this, R.string.toast_search, Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
