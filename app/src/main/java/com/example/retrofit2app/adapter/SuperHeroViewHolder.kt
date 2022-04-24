package com.example.retrofit2app.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit2app.ItemActivity
import com.example.retrofit2app.SuperHero
import com.example.retrofit2app.databinding.ItemSuperHeroBinding

class SuperHeroViewHolder (view:View):RecyclerView.ViewHolder(view){

    val binding  =  ItemSuperHeroBinding.bind(view)

    fun render (superHeroObj:SuperHero){
        binding.tvSuperHero.text = superHeroObj.superhero
        binding.tvRealName.text = superHeroObj.realname
        binding.tvPublisher.text = superHeroObj.publisher

        Glide.with(binding.ivItemImage.context)
            .load(superHeroObj.photo)
            .into(binding.ivItemImage)

        binding.cvItem.setOnClickListener {
            val i = Intent(binding.cvItem.context,ItemActivity::class.java)
            i.putExtra("superHero",superHeroObj)
            binding.cvItem.context.startActivity(i)

        }


    }


}