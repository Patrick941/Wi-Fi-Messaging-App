package com.example.messagingapp

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FullscreenActivity : AppCompatActivity() {

    private val thisName = "MainActivity"
    private var messageToSend= "Nothing"
    private var connected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MyTag", "Program Created")
        setContentView(R.layout.activity_fullscreen)
        val send = findViewById<Button>(R.id.SendButton)
        val wifiButton = findViewById<FloatingActionButton>(R.id.WiFiButton)
        val message = findViewById<TextView>(R.id.UserNameText)
        send.setOnClickListener{
            messageToSend = message.text.toString()
            message.text = ""
            Log.i("MyTag", "Sending Message \"$messageToSend\" ")
        }
        wifiButton.setOnClickListener{
            if(connected){
                Log.i("MyTag", "Connected To Wi-Fi")
            }
            else{
                Log.i("MyTag", "Not Connected To Wi-Fi")
            }
        }
    }

    override fun onResume(){
        super.onResume()
        Log.i("MyTag", "resuming $thisName")
    }

    override fun onStart(){
        super.onStart()
        Log.i("MyTag", "starting $thisName")
    }

    override fun onStop(){
        super.onStop()
        Log.i("MyTag", "stopping $thisName")
    }

    override fun onRestart(){
        super.onRestart()
        Log.i("MyTag", "restarting $thisName")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("MyTag", "destroying $thisName")
    }
}