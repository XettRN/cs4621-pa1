package com.example.pa1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newMeme: Button = findViewById(R.id.button)
        newMeme.setOnClickListener { randImage() }
    }

    private fun randImage() {
        val meme: ImageView = findViewById(R.id.imageView)
        val randInt = (1..5).random()

        val drawable = when (randInt) {
            1 -> R.drawable.pepsidog
            2 -> R.drawable.cokedog
            3 -> R.drawable.canpepsidog
            4 -> R.drawable.coorsdog
            else -> R.drawable.drpepperdog
        }

        meme.setImageResource(drawable)
        meme.contentDescription = randInt.toString()
    }
}