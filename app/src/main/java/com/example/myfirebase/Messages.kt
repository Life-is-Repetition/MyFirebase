package com.example.myfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Messages : AppCompatActivity() {
    private var adapter: MessageAdater? = null
    private val db: FirebaseFirestore = Firebase.firestore
    private val postCollectionRef = db.collection("user")
    private val recyclerViewItems by lazy { findViewById<RecyclerView>(R.id.recyclerViewItems) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.messages_view)

        recyclerViewItems.layoutManager = LinearLayoutManager(this)
        adapter = MessageAdater(this, emptyList())
        recyclerViewItems.adapter = adapter
        updateList()  // list items on recyclerview

    }
    private fun updateList() {
        postCollectionRef.get().addOnSuccessListener {
            val posts = mutableListOf<Item>()
            for (doc in it) {
                posts.add(Item(doc))
            }
            adapter?.updateList(posts)
        }
    }
}