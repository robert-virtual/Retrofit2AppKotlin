package com.example.retrofit2app.adapter

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit2app.ItemActivity
import com.example.retrofit2app.R
import com.example.retrofit2app.SuperHero

class SuperHeroViewHolder (private val view:View):RecyclerView.ViewHolder(view){
    val cardViewItem = view.findViewById<CardView>(R.id.cv_item)
    val superHero = view.findViewById<TextView>(R.id.tv_super_hero)
    val realName = view.findViewById<TextView>(R.id.tv_real_name)
    val publisher = view.findViewById<TextView>(R.id.tv_publisher)
    val itemImage= view.findViewById<ImageView>(R.id.iv_item_image)
    fun render (superHeroObj:SuperHero){
        superHero.text = superHeroObj.superhero
        realName.text = superHeroObj.realname
        publisher.text = superHeroObj.publisher

        Glide.with(view.context)
            .load(superHeroObj.photo)
            .into(itemImage)

        cardViewItem.setOnClickListener {
            val i = Intent(view.context,ItemActivity::class.java)
            i.putExtra("superHero",superHeroObj.superhero)
            i.putExtra("realName",superHeroObj.realname)
           view.context.startActivity(i)

        }


    }


}