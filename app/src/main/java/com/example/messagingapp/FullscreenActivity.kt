package com.example.messagingapp

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.WindowInsets
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.messagingapp.databinding.ActivityFullscreenBinding


class FullscreenActivity : AppCompatActivity() {

    private val thisName = "MainActivity"
    private var messageToSend= "Nothing"
    private var connected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MyTag", "Program Created")
        setContentView(R.layout.activity_fullscreen)
        val send = findViewById<Button>(R.id.SendButton)
        val wifiButton = findViewById<Button>(R.id.WiFiButton)
        val message = findViewById<TextView>(R.id.TextBox)
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