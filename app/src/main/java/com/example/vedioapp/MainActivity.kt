package com.example.vedioapp

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    lateinit var videoView: VideoView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      


        val videoUrl="https://resource.flexclip.com/templates/video/720p/filmmaking-portfolio.mp4"

        videoView=findViewById(R.id.videoView)
        
        val mediaController=MediaController(this)
        
        videoView.setVideoURI(Uri.parse(videoUrl))
        videoView.setMediaController(mediaController)
        videoView.requestFocus()
        videoView.start()
        videoView.pause()
        
        videoView.setOnCompletionListener {
            Toast.makeText(this, "Video is completed", Toast.LENGTH_SHORT).show()
        }
        videoView.setOnErrorListener { mediaPlayer, i, i2 ->

            Toast.makeText(this, "Network error", Toast.LENGTH_SHORT).show()
            true
        }
    }
}