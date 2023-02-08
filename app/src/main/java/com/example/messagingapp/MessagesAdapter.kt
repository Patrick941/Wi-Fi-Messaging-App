package com.example.messagingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessagesAdapter(private val context: FullscreenActivity) :
    RecyclerView.Adapter<MessagesAdapter.UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.message_box_recycler, parent, false)
        return MessagesAdapter.UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.messageText.text = "testing messages"
    }

    override fun getItemCount(): Int {
        return 5
    }

    class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val messageText: TextView = itemView.findViewById(R.id.messageText)
    }
}