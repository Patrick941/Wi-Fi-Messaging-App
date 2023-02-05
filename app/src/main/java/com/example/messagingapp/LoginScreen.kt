package com.example.messagingapp

import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaCodec.MetricsConstants.MODE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text
import java.sql.Types.NULL

class LoginScreen : AppCompatActivity() {

    private val thisName = "Login Screen"

    private lateinit var sharedFile:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor

    private lateinit var confirmButton : Button
    private lateinit var password : TextView
    private lateinit var username : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MyTag", "Program Created")
        setContentView(R.layout.activity_login_screen)

        confirmButton = findViewById<Button>(R.id.ConfirmButton)
        password = findViewById<TextView>(R.id.PasswordText)
        username = findViewById<TextView>(R.id.UserNameText)

        sharedFile = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sharedFile.edit()


        confirmButton.setOnClickListener{
            Log.i("MyTag", "Storing password as ${password.text} and storing username as ${username.text}")
            editor.apply{
                putString("storedPassword", password.text.toString())
                putString("storedUsername", username.text.toString())
                editor.commit()
            }
        }

    }

    override fun onPause(){
        super.onPause()
        Log.i("MyTag", "pausing $thisName")
    }

    override fun onResume(){
        super.onResume()
        Log.i("MyTag", "resuming $thisName")
        password.text = sharedFile.getString("storedPassword", "").toString()
        username.text = sharedFile.getString("storedUsername", "").toString()
        Log.i("MyTag", "Restored username is ${username.text}, restored password is ${password.text}")
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