package com.example.laura.heartbeats;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Main5Activity extends AppCompatActivity {

    Button clk;
    VideoView videov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        clk = (Button)findViewById(R.id.button3);
        videov = (VideoView)findViewById(R.id.videoView);
    }
    public void videoplay(View v)
    {
        String videopath = "android.resource://com.example.laura.heartbeats/"+R.raw.heartrate;
        Uri uri = Uri.parse(videopath);
        videov.setVideoURI(uri);
        videov.start();
    }

}
