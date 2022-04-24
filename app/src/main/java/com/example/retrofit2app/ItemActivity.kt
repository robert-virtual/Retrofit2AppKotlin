package com.example.retrofit2app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        val superHero:SuperHero = intent.getSerializableExtra("superHero") as SuperHero
        title = superHero.superhero
        val realname = findViewById<TextView>(R.id.real_name)
        val publisher = findViewById<TextView>(R.id.publisher)
        val image = findViewById<ImageView>(R.id.iv_image)
        realname.text = superHero.realname
        publisher.text = superHero.publisher
        Glide.with(applicationContext)
            .load(superHero.photo)
            .into(image)

    }
}