package com.example.retrofit2app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2app.R
import com.example.retrofit2app.SuperHero

class SuperHeroAdapter(private val superHeroList:List<SuperHero>,private val onClickListener:(SuperHero)->Unit):RecyclerView.Adapter<SuperHeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_super_hero,parent,false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superHeroList[position]
        holder.render(item,onClickListener)
    }

    override fun getItemCount(): Int {
        return superHeroList.size
    }

}