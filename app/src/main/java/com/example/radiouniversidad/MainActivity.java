package com.example.radiouniversidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView playPause;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playPause = findViewById(R.id.playPause);

        mediaPlayer = new MediaPlayer();
        preparedMediaPlayer();

        // Botón de Play/Pausa
        playPause.setOnClickListener(btnClickListener);

    }


    private View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                playPause.setImageResource(R.drawable.play_button);
            } else {
                mediaPlayer.start();
                playPause.setImageResource(R.drawable.pause_button);
            }

        }
    };

    private void preparedMediaPlayer() {
        try{
            mediaPlayer.setDataSource("https://fm.unam.edu.ar/fm");
            mediaPlayer.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }



    public void openFacebookApp(View view) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/fmunam987"));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openYoutubeApp(View view) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/fmuniversidad987"));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openWebApp(View view) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://transmedia.unam.edu.ar/index.php/radio/fm-universidad-98-7"));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}