package com.example.recipes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MexicanActivity extends YouTubeBaseActivity {

    private Intent googleMap;
    Button mapButton;

    YouTubePlayerView mYoutubePlayView;
    Button playButton;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mexican);
        init();

        playButton = (Button) findViewById(R.id.playButton);
        mYoutubePlayView = (YouTubePlayerView) findViewById(R.id.youtubePlay);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("kUha2MPA7Z8");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mYoutubePlayView.initialize(YoutubeConfig.getApiKey(), mOnInitializedListener);
            }
        });
    }
    public void init()
    {
        mapButton = (Button) findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleMap = new Intent(Intent.ACTION_VIEW);

                googleMap.setData(Uri.parse("geo:0,0?q=le Mexico,Mexico"));
                startActivity(googleMap);
            }
        });
    }
}
