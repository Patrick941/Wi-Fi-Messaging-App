package com.example.messagingapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FullscreenActivity : AppCompatActivity() {

    private val thisName = "MainActivity"
    private var messageToSend= "Nothing"

    private lateinit var receiverUser : User
    private lateinit var senderUser : User

    private lateinit var messagesRecyclerView: RecyclerView
    private lateinit var adapter: MessagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MyTag", "Program Created")
        setContentView(R.layout.activity_fullscreen)

        val send = findViewById<Button>(R.id.SendButton)
        val message = findViewById<TextView>(R.id.MessageText)

        val messaging = MessageSendClass()

        receiverUser = intent.getSerializableExtra("ReceiverUser") as User
        senderUser = intent.getSerializableExtra("SenderUser") as User

        adapter = MessagesAdapter(this)
        messagesRecyclerView = findViewById<RecyclerView>(R.id.MessagesList)
        messagesRecyclerView.layoutManager = LinearLayoutManager(this)
        messagesRecyclerView.adapter = adapter

        //receiverUser = (intent.extras?.getSerializable("ReceiverUser") ?: null) as User
        //senderUser = (intent.extras?.getSerializable("SenderUser") ?: null) as User

        send.setOnClickListener{
            messageToSend = message.text.toString()
            message.text = ""
            messaging.sendMessage(messageToSend, senderUser?.uid, receiverUser?.uid)

            Log.i("MyTag", "Sending Message \"$messageToSend\" ")
        }
    }

    override fun onPause(){
        super.onPause()
        Log.i("MyTag", "pausing $thisName")
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