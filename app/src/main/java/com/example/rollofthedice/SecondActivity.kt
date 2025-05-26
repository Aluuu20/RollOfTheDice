package com.example.rollofthedice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        // ImageView per mostrare il volto del dado questa la metto sulla terza activity

        val rollbtn = findViewById<Button>(R.id.button)
        rollbtn.setOnClickListener {


            Toast.makeText(this, "Dado lanciato...", Toast.LENGTH_SHORT).show()

            GlobalScope.launch(Dispatchers.Main) {
                delay(3000)  // Ritardo di 2 secondi
                val randomNumber = (1..6).random()

                val imgFaceDice = when (randomNumber) {
                    1 -> R.drawable.dice_face_1
                    2 -> R.drawable.dice_face_2
                    3 -> R.drawable.dice_face_3
                    4 -> R.drawable.dice_face_4
                    5 -> R.drawable.dice_face_5
                    else -> R.drawable.dice_face_6
                }
                val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                intent.putExtra("NumeroDadi", imgFaceDice)
                startActivity(intent)
            }


        }
    }
}