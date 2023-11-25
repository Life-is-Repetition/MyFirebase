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


        val button=findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            startActivity(
                Intent(this, ViewActivity::class.java)
            )
            finish()
        }
    }
}
