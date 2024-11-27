package com.example.intentprj

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.media.MediaPlayer
import android.widget.Button
import android.widget.TextView

class MusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        val mp = MediaPlayer.create(this, R.raw.californiadreamin)

        val play = findViewById<Button>(R.id.play_btn)
        play.setOnClickListener {
            mp.start()
        }

        val pause = findViewById<Button>(R.id.pause_btn)
        pause.setOnClickListener {
            mp.pause()
        }

        val musicLocation = findViewById<TextView>(R.id.musiclocation)
        play.setOnClickListener {
            mp.start()

            val currentPosition = mp.currentPosition
            musicLocation.text = "$currentPosition "
        }

        pause.setOnClickListener {
            mp.pause()

            val currentPosition = mp.currentPosition
            musicLocation.text = " $currentPosition "
        }
    }
}
