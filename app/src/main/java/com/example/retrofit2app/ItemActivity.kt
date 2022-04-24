package com.example.retrofit2app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        val superHero = intent.getStringExtra("superHero")
        val realName = intent.getStringExtra("realName")
        title = superHero
        val text = findViewById<TextView>(R.id.real_name)
        text.text = realName
    }
}