package com.example.retrofit2app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
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
       recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList)
    }
}