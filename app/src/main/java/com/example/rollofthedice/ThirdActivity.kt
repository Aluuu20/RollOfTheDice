package com.example.rollofthedice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)
        val inputNumber = findViewById<EditText>(R.id.input_number)
        val imgFaceDice = intent.getIntExtra("NumeroDadi", R.drawable.dice_face_1)
        val playbtn = findViewById<Button>(R.id.play_btn)

        playbtn.setOnClickListener {
            playbtn.isEnabled = false
            val inputText = inputNumber.text.toString()

            if (inputText.isNotEmpty()) {
                val numeroInserito = inputText.toIntOrNull()

                if (numeroInserito != null && numeroInserito in 1..6) {

                    val numeroDado = when(imgFaceDice) {
                        R.drawable.dice_face_1 -> 1
                        R.drawable.dice_face_2 -> 2
                        R.drawable.dice_face_3 -> 3
                        R.drawable.dice_face_4 -> 4
                        R.drawable.dice_face_5 -> 5
                        R.drawable.dice_face_6 -> 6
                        else -> -1
                    }

                    Toast.makeText(this, "Hai inserito il numero: $numeroInserito", Toast.LENGTH_SHORT).show()

                    if (numeroInserito == numeroDado) {
                        Toast.makeText(this, "Complimenti hai vinto 😘!", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Mi dispiace hai perso 😢", Toast.LENGTH_LONG).show()
                    }

                    val intent = Intent(this, FourthActivity::class.java)
                    intent.putExtra("NumeroDadi", imgFaceDice)
                    intent.putExtra("NumeroInserito", numeroInserito)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Inserisci un numero valido tra 1 e 6!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Inserisci un numero!", Toast.LENGTH_SHORT).show()
            }

            playbtn.isEnabled = true
        }

    }
}