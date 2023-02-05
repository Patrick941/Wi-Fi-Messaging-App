package com.example.messagingapp

import ndroidx.appcompat.app.AppCompatActivity
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
import com.google.android.material.floatingactionbutton.FloatingActionButton


class LoginScreen : AppCompatActivity() {

    val thisName = "LoginScreen"

    override fun onCreate() {
        super.onCreate(savedInstanceState)
        Log.i("MyTag", "Program Created")
        setContentView(R.layout.activity_fullscreen)
        val send = findViewById<Button>(R.id.SendButton)
        val wifiButton = findViewById<FloatingActionButton>(R.id.WiFiButton)
        val message = findViewById<TextView>(R.id.TextBox)
    }

    override fun onResume() {
        super.onResume()
        Log.i("MyTag", "resuming $thisName")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MyTag", "starting $thisName")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MyTag", "stopping $thisName")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MyTag", "restarting $thisName")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MyTag", "destroying $thisName")
    }
}