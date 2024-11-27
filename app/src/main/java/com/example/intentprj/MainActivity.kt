package com.example.intentprj

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.net.Uri
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val latitude = 40.757834
        val longitude = 47.059979


        val calling = findViewById<Button>(R.id.call_btn)
        calling.setOnClickListener {
            val phoneNumber = calling.text
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(intent)
        }
        val seelocation=findViewById<Button>(R.id.map_btn)
        seelocation.setOnClickListener{
            openMapWithLocation(latitude, longitude)
        }
        val seewebpage=findViewById<Button>(R.id.webpage_btn)
        seewebpage.setOnClickListener{
            val webpage=Uri.parse("https://beu.edu.az/en")
            val intent=Intent(Intent.ACTION_VIEW,webpage)
            startActivity(intent)
        }
        val listenmusic=findViewById<Button>(R.id.listen)
        listenmusic.setOnClickListener{
            val intent=Intent(this,MusicActivity::class.java)
            startActivity(intent)
        }

    }



    private fun openMapWithLocation(latitude: Double, longitude: Double) {
        val uri = "geo:$latitude,$longitude"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        intent.setPackage("com.google.android.apps.maps")

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
