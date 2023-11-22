package com.example.myfirebase

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {
    private var adapter: MyAdapter? = null
    private val db: FirebaseFirestore = Firebase.firestore
    private val postCollectionRef = db.collection("post")
    private val recyclerViewItems by lazy { findViewById<RecyclerView>(R.id.recyclerViewItems) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_sale_list)
        recyclerViewItems.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(this, emptyList())
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