package com.example.myfirebase

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ItemDetailsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_post)

        val itemId = intent.getStringExtra("ITEM_ID")
        val itemSUB = intent.getStringExtra("ITEM_SUB")
        val itemPRICE = intent.getStringExtra("ITEM_PRICE")
        val itemSALE = intent.getStringExtra("ITEM_SALE")
        val itemCON = intent.getStringExtra("ITEM_CON")

        val subject=findViewById<TextView>(R.id.subject)
        val content=findViewById<TextView>(R.id.content)
        val price=findViewById<TextView>(R.id.textView3)
        val sale=findViewById<TextView>(R.id.textView4)
        val name=findViewById<TextView>(R.id.textView10)

        name.text = "$itemId"
        subject.text = "$itemSUB"
        content.text = "$itemId"
        price.text = "$itemPRICE"
        sale.text = "$itemSALE"
        content.text = "$itemCON"


        val button=findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            startActivity(
                Intent(this, SendActivity::class.java)
            )
            finish()
        }
    }
}
