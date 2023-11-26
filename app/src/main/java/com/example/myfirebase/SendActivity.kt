package com.example.myfirebase

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SendActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.send)

        val subjectId=intent.getStringExtra("SUBJECT")
        val senderId=intent.getStringExtra("SENDER_ID")
        val receiverId=intent.getStringExtra("POST_AUTHOR_ID")

        val subject=findViewById<TextView>(R.id.textView)
        val sender=findViewById<TextView>(R.id.textView2)
        val receiver=findViewById<TextView>(R.id.textView3)

        subject.text = "$subjectId"
        sender.text = "$senderId"
        receiver.text = "$receiverId"


        val button=findViewById<Button>(R.id.modify)
        button.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
            finish()
        }
    }
}
