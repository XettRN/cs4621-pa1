package com.example.pa1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newMeme: Button = findViewById(R.id.button)
        newMeme.setOnClickListener { randImage() }
    }

    private fun randImage() {
        val meme: ImageView = findViewById(R.id.imageView)

        //Cloud storage pulls
        val storage = Firebase.storage.reference
        val canDog = storage.child("images/canpepsidog.jpg")
        val cokeDog = storage.child("images/cokedog.jpg")
        val coorsDog = storage.child("images/coorsdog.jpg")
        val drDog = storage.child("images/drpepperdog.jpg")
        val pepsiDog = storage.child("images/pepsidog.jpg")

        //Random Image
        val randInt = (1..5).random()
        val randImage = when (randInt) {
            1 -> canDog
            2 -> cokeDog
            3 -> coorsDog
            4 -> drDog
            else -> pepsiDog
        }

        //Display using Glide
        Glide.with(this)
            .load(randImage)
            .into(meme)
        meme.contentDescription = randInt.toString()
    }
}