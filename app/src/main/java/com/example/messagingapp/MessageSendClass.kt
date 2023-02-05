package com.example.messagingapp

import android.util.Log
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

class MessageSendClass {
    private lateinit var messages: ArrayList<String>

    private lateinit var mDbRef: DatabaseReference

    constructor(){
        messages = ArrayList()
    }


    fun sendMessage(message : String, uidSender: String?, uidReceiver : String?){
        Log.i("MyTag", "receiver has UID $uidReceiver")
        mDbRef = FirebaseDatabase.getInstance().getReference()
        Log.i("MyTag", "Sending the message $message from ${uidSender!!} to ${uidReceiver!!}")

        mDbRef.child("messages").child(uidSender!!).child(uidReceiver).addListenerForSingleValueEvent(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                Log.i("MyTag", "Current text chain is")
                for(index in 0 until messages.size){
                    Log.i("MyTag", "${messages[index]}")
                }

                val value = snapshot.getValue<String>()
                Log.i("MyTag", "Database was changed to $value")
                messages.add(value!!)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

        mDbRef.child("messages").child(uidSender!!).child(uidReceiver!!).setValue(message)
    }
}