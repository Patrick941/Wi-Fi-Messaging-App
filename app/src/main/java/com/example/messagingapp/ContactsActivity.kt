package com.example.messagingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import okhttp3.internal.notify
import okhttp3.internal.notifyAll

class ContactsActivity : AppCompatActivity() {

    private val thisName = "Contacts Activity"

    private lateinit var contactsRecyclerView: RecyclerView
    private lateinit var userList: ArrayList<User>
    private lateinit var adapter: ContactsAdapter

    private lateinit var mDbRef : DatabaseReference
    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        Log.i("MyTag", "creating $thisName")

        mDbRef = FirebaseDatabase.getInstance().getReference()
        mAuth = FirebaseAuth.getInstance()

        userList = ArrayList()
        adapter = ContactsAdapter(this, userList)
        contactsRecyclerView = findViewById(R.id.ContactsList)
        contactsRecyclerView.layoutManager = LinearLayoutManager(this)
        contactsRecyclerView.adapter = adapter

        mDbRef.child("user").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                for(postSnapshot in snapshot.children){
                    val currentUser = postSnapshot.getValue(User::class.java)

                    if(mAuth.currentUser?.uid == currentUser?.uid) {
                        currentUser?.nick = "you"
                    }
                    userList.add(currentUser!!)
                    Log.i("MyTag", "Adding user with email ${currentUser.email} to contacts")
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
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