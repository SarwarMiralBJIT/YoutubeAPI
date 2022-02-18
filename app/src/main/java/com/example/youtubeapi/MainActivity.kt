package com.example.youtubeapi

import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class MainActivity : YouTubeBaseActivity()  {

        val api_key =  "AIzaSyAMAjiJIbqD900zO02pzAu0SgAvHN-I1Ms"

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Get reference to the view of Video player
            val ytPlayer = findViewById<YouTubePlayerView>(R.id.ytPlayer)

            ytPlayer.initialize(api_key, object : YouTubePlayer.OnInitializedListener{
                // Implement two methods by clicking on red error bulb
                // inside onInitializationSuccess method
                // add the video link or the
                // playlist link that you want to play
                // In here we also handle the play and pause functionality
                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider?,
                    player: YouTubePlayer?,
                    p2: Boolean
                ) {
                    player?.loadVideo("vYquumk4nWw")
                    player?.play()
                }

                // Inside onInitializationFailure
                // implement the failure functionality
                // Here we will show toast
                override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
                ) {
                    Toast.makeText(this@MainActivity , "Video player Failed" , Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
