package com.firstapp.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
VideoView videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoview=(VideoView) findViewById(R.id.video);
        String videopath=new StringBuilder("android.resource://")
                .append(getPackageName()).append("/raw/splash")
                .toString();
        videoview.setVideoPath(videopath);
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
Intent intent=new Intent(getApplicationContext(),LogIn.class);
startActivity(intent);
finish();
                    }
                },300);
            }
        });
        videoview.start();
    }
}