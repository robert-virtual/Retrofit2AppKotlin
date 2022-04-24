package com.example.retrofit2app

import java.io.Serializable


data class SuperHero(
    val superhero:String,
    val publisher:String,
    val realname:String,
    val photo:String
):Serializable