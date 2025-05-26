package com.example.rollofthedice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourth)
        val imgDice = findViewById<ImageView>(R.id.imgDice)
        val btnritenta = findViewById<Button>(R.id.idbuttonRitenta)


        val diceImageResId = intent.getIntExtra("NumeroDadi", R.drawable.dice_face_1)
        imgDice.setImageResource(diceImageResId)


        btnritenta.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}