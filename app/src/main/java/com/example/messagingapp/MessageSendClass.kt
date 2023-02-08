package com.example.messagingapp

import android.util.Log
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

class MessageSendClass {
    private var lastMsg: String = "null"

    private lateinit var mDbRef: DatabaseReference


    fun sendMessage(message : String, uidSender: String?, uidReceiver : String?){
        var msgToSend : String = "null"
        Log.i("MyTag", "receiver has UID $uidReceiver")
        mDbRef = FirebaseDatabase.getInstance().getReference()
        Log.i("MyTag", "Sending the message $message from ${uidSender!!} to ${uidReceiver!!}")

        mDbRef.child("messages").child(uidSender!!).child(uidReceiver).addListenerForSingleValueEvent(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(lastMsg != "null"){
                    msgToSend = "$lastMsg$message~"
                } else {
                    val value = snapshot.getValue<String>()
                    if(value == null) {
                        msgToSend = "$message~"
                    } else {
                        msgToSend = "$value$message~"
                    }
                }
                mDbRef.child("messages").child(uidSender!!).child(uidReceiver!!).setValue(msgToSend)

                Log.i("MyTag", "Database was changed to $msgToSend")
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}