package com.mj.noteblocksoundboard;

import android.annotation.TargetApi;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Environment;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public String[] pitches = new String[]{
            "F#3",
            "G3",
            "G#3",
            "A3",
            "A#3",
            "B3",
            "C4",
            "C#4",
            "D4",
            "D#4",
            "E4",
            "F4",
            "F#4",
            "G4",
            "A4",
            "A#4",
            "B4",
            "C5",
            "C#5",
            "D5",
            "D#5",
            "E5",
            "F5",
            "F#5"
    };
    public boolean usingDirtSounds = true;
    public int currentPitch = 0;

    private MediaPlayer mediaPlayer = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton increaseKeyButton = findViewById(R.id.increaseKey);
        final FloatingActionButton decreaseKeyButton = findViewById(R.id.decreaseKey);

        final Button playCurrentNoteButton = findViewById(R.id.playCurrentNote);
        final Button playSunflowerButton = findViewById(R.id.playSunflower);
        final Button playSickoModeButton = findViewById(R.id.playSickoMode);
        final Button playBadGuyButton = findViewById(R.id.playBadGuy);

        final TextView currentPitchText = findViewById(R.id.currentPitchText);

        mediaPlayer = MediaPlayer.create(this, R.raw.dirt_f_sharp3);

        increaseKeyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Increased key", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                ++currentPitch;
                if(currentPitch > pitches.length - 1)
                    currentPitch = 0;
                currentPitchText.setText("Current Key: "+pitches[currentPitch]);

                playCurrentSound();
            }
        });

        decreaseKeyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Decreased key", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                --currentPitch;
                if(currentPitch < 0)
                    currentPitch = pitches.length - 1;
                currentPitchText.setText("Current Key: "+pitches[currentPitch]);

                playCurrentSound();
            }
        });

        playCurrentNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Snackbar.make(view, "Playing current sound", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                playCurrentSound();
            }
        });

        playSunflowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Snackbar.make(view, "Playing Sunflower", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                playSong(true);
            }
        });

        playSickoModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Snackbar.make(view, "Playing Sicko Mode", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                playSong(false);
            }
        });

        playBadGuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Snackbar.make(view, "Playing Bad Guy", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                playBadGuy();
            }
        });

        currentPitchText.setText("Current Pitch: "+pitches[currentPitch]);
    }

    @TargetApi(21)
    private void playCurrentSound() {
        mediaPlayer.stop();
        switch (pitches[currentPitch]) {
            case ("A#3"):
                mediaPlayer = MediaPlayer.create(this, R.raw.dirt_a_sharp3);
                break;
            case ("A#4"):
                mediaPlayer = MediaPlayer.create(this, R.raw.dirt_a_sharp4);
                break;
            case ("A3"):
                mediaPlayer = MediaPlayer.create(this, R.raw.dirt_a3);
                break;
            case ("A4"):
                mediaPlayer = MediaPlayer.create(this, R.raw.dirt_a4);
                break;
            case ("B3"):
                mediaPlayer = MediaPlayer.create(this, R.raw.dirt_b3);
                break;
            case ("B4"):
                mediaPlayer = MediaPlayer.create(this, R.raw.dirt_b4);
                break;
            case ("C#4"):
                mediaPlayer = MediaPlayer.create(this, R.raw.dirt_c_sharp4);
                break;
            case ("C#5"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_c_sharp5);
                    break;
                case ("C4"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_c4);
                    break;
                case ("C5"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_c5);
                    break;
                case ("D#4"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_d_sharp4);
                    break;
                case ("D#5"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_d_sharp5);
                    break;
                case ("D4"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_d4);
                    break;
                case ("D5"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_d5);
                    break;
                case ("E4"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_e4);
                    break;
                case ("E5"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_e5);
                    break;
                case ("F#3"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_f_sharp3);
                    break;
                case ("F#4"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_f_sharp4);
                    break;
                case ("F#5"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_f_sharp5);
                    break;
                case ("F4"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_f4);
                    break;
                case ("F5"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_f5);
                    break;
                case ("G#3"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_g_sharp3);
                    break;
                case ("G#4"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_g_sharp4);
                    break;
                case ("G3"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_g3);
                    break;
                case ("G4"):
                    mediaPlayer = MediaPlayer.create(this, R.raw.dirt_g4);
                    break;
        }
        mediaPlayer.start();
    }

    @TargetApi(21)
    private void playSong(boolean askingEmmaOut){
        mediaPlayer.stop();
        if (askingEmmaOut)
            mediaPlayer = MediaPlayer.create(this, R.raw.sunflower_noteblock);
        else
            mediaPlayer = MediaPlayer.create(this, R.raw.sicko_noteblocks);
        mediaPlayer.start();
    }

    private void playBadGuy(){
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.bad_guy_noteblock);
        mediaPlayer.start();
    }
}
