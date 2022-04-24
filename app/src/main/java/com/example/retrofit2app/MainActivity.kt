package com.example.retrofit2app

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.retrofit2app.api.ApiService
import com.example.retrofit2app.api.BASE_URL
import com.example.retrofit2app.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        backgroundAnimation()
        makeApiRequet()
        binding.floatingBtn.setOnClickListener {
            makeApiRequet()

            binding.floatingBtn.animate().apply {
                rotationBy(360f)
                duration = 1000
            }.start()

        }
    }
    fun backgroundAnimation() {
        val animationDrawable:AnimationDrawable = binding.rlMainScreen.background as AnimationDrawable
        animationDrawable.apply {
            setEnterFadeDuration(1000)
            setExitFadeDuration(3000)
            start()
        }

    }

    fun makeApiRequet() {
        binding.pogressBar.visibility = View.VISIBLE
        binding.tvError.visibility = View.GONE

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val res = api.getRandomDog()
                if (!res.isSuccessful){
                  throw Exception(res.message())
                }
                val data = res.body()
                withContext(Dispatchers.Main){
                    Glide
                        .with(applicationContext)
                        .load(data?.url)
                        .listener(object:RequestListener<Drawable>{
                            override fun onResourceReady(
                                resource: Drawable?,
                                model: Any?,
                                target: Target<Drawable>?,
                                dataSource: DataSource?,
                                isFirstResource: Boolean
                            ): Boolean {
                                    binding.pogressBar.visibility = View.GONE
                                return false
                            }

                            override fun onLoadFailed(
                                e: GlideException?,
                                model: Any?,
                                target: Target<Drawable>?,
                                isFirstResource: Boolean
                            ): Boolean {
                                binding.pogressBar.visibility = View.GONE
                                return false
                            }
                        })
                        .into(binding.ivImage)
                }
            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    binding.tvError.visibility = View.VISIBLE
                    binding.tvError.setText(e.message)
                    binding.pogressBar.visibility = View.GONE
                }
            }

        }

    }
}