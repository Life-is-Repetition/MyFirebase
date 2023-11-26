package com.example.myfirebase

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class Post(
    val subject: String,
    val price: String,
    val content: String,
    val sale:Boolean,
)

class SaleItemActivity: AppCompatActivity() {//글쓰기
    private val db: FirebaseFirestore = Firebase.firestore
    private val postCollectionRef = db.collection("post")
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_post)
        val subject=findViewById<TextView>(R.id.subject)
        val value=findViewById<TextView>(R.id.value)
        val content=findViewById<TextView>(R.id.content)
        val currentUser = Firebase.auth.currentUser // 현재 로그인한 사용자 가져오기


        val button=findViewById<Button>(R.id.modify)
        button.setOnClickListener {
            val newPost = Post(
                subject = subject.text.toString(),
                price = value.text.toString(),
                content = content.text.toString(),
                sale = true
            )

            val newPostRef = postCollectionRef.document(currentUser?.uid ?: "")

            newPostRef.set(newPost)
                .addOnSuccessListener {
                    startActivity(
                        Intent(this, MainActivity::class.java)
                    )
                    finish()            }
                .addOnFailureListener { e ->
                    // 실패했을 때 처리할 작업
                    Log.e(TAG, "Error adding document", e)
                }
        }
    }
}