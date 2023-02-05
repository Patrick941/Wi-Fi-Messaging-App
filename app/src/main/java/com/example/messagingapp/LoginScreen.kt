package com.example.messagingapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginScreen : AppCompatActivity() {

    private val thisName = "Login Screen"

    private lateinit var sharedFile:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor

    private lateinit var signUpButton : Button
    private lateinit var password : TextView
    private lateinit var username : TextView
    private lateinit var logInButton : Button

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MyTag", "Program Created")
        setContentView(R.layout.activity_login_screen)

        mAuth = FirebaseAuth.getInstance()

        signUpButton = findViewById(R.id.SignUpButton)
        logInButton = findViewById(R.id.LogInButton)
        password = findViewById(R.id.PasswordText)
        username = findViewById(R.id.UserNameText)

        sharedFile = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sharedFile.edit()


        signUpButton.setOnClickListener{
            Log.i("MyTag", "Storing password as ${password.text} and storing username as ${username.text}")
            editor.apply{
                putString("storedPassword", password.text.toString())
                putString("storedUsername", username.text.toString())
                editor.commit()
            }
            signUp(username.text.toString(), password.text.toString())
        }

        logInButton.setOnClickListener{
            Log.i("MyTag", "Storing password as ${password.text} and storing username as ${username.text}")
            editor.apply{
                putString("storedPassword", password.text.toString())
                putString("storedUsername", username.text.toString())
                editor.commit()
            }
            logIn(username.text.toString(), password.text.toString())
        }

    }

    private fun logIn(email: String, password: String){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d("MyTag", "Log-In:success")
                Toast.makeText(baseContext, "Log-In success",
                    Toast.LENGTH_SHORT).show()
                val user = mAuth.currentUser
                val intent = Intent(this, ContactsActivity::class.java)
                startActivity(intent)
            } else {
                // If sign in fails, display a message to the user.
                Log.w("MyTag", "Log-In With Email:failure", task.exception)
                Toast.makeText(baseContext, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signUp(email: String, password : String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("MyTag", "createUserWithEmail:success")
                    Toast.makeText(baseContext, "New Account Created.",
                        Toast.LENGTH_SHORT).show()
                    val user = mAuth.currentUser
                    val intent = Intent(this, ContactsActivity::class.java)
                    intent.putExtra("user", email)
                    intent.putExtra("password", password)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("MyTag", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
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