package com.example.messagingapp

import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseUser

class ContactsAdapter(private val context: ContactsActivity, private val userList: ArrayList<User>) :
    RecyclerView.Adapter<ContactsAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.text_box_recycler, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.textName.text = userList[position].nick
        holder.contactButton.setBackgroundColor(Color.TRANSPARENT)
        holder.contactButton.setOnClickListener{
            var user : User? = null
            for(index in 0 until userList.size){
                if(userList[index].nick == "you"){
                    Log.i("MyTag", "Current user found")
                    user = userList[index]
                }
            }
            if (user != null) {
                Log.i("MyTag", "Opening chat between ${user.nick} and ${userList[position].nick}")
                val intent = Intent(context, FullscreenActivity::class.java)
                intent.putExtra("ReceiverUser", userList[position])
                intent.putExtra("SenderUser", user)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textName: TextView = itemView.findViewById(R.id.contactText)
        val contactButton: Button = itemView.findViewById(R.id.contactButton)
    }

}