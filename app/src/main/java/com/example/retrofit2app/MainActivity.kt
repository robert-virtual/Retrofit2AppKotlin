package com.example.retrofit2app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.retrofit2app.adapter.SuperHeroAdapter
import com.example.retrofit2app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    fun initRecyclerView(){
       val recyclerView =  binding.recyclerSuperHero
        recyclerView.layoutManager = LinearLayoutManager(this)
       recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList,{onSelectedItem(it)})
    }
    fun onSelectedItem(superHero:SuperHero){
       binding.recyclerSuperHero.visibility = View.GONE
        binding.itemSelected.visibility = View.VISIBLE
        binding.tvRealName.text = superHero.realname
        binding.tvSuperHero.text = superHero.superhero
        binding.tvPublisher.text = superHero.publisher

        Glide.with(applicationContext)
            .load(superHero.photo)
            .into(binding.ivItemImage)
        binding.btnCloseItem.setOnClickListener {

            binding.recyclerSuperHero.visibility = View.VISIBLE
            binding.itemSelected.visibility = View.GONE
        }
    }
}