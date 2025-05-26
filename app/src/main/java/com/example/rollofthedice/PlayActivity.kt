package com.example.rollofthedice

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.log


class PlayActivity : AppCompatActivity() {
    private var numberMatch = 0
    private var numberMatchWin = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_play)

        val btnPlay = findViewById<Button>(R.id.idbtnPlay)  // Bottone per giocare
        val textNumber = findViewById<TextView>(R.id.textNumber)  // TextView per visualizzare il numero del dado
        val imgDice = findViewById<ImageView>(R.id.imgDice)  // ImageView per mostrare il volto del dado
        val textOutput = findViewById<TextView>(R.id.textOutput)  // TextView per il risultato del gioco
        val inputNumber = findViewById<EditText>(R.id.editTextInput)  // EditText per inserire il numero
        val numberMatchtxt = findViewById<TextView>(R.id.txtNumberMatch)
        val numberMatchWintxt = findViewById<TextView>(R.id.txtNumberMatchWin)

        btnPlay.setOnClickListener(View.OnClickListener {
            btnPlay.isEnabled = false

            numberMatch++

            numberMatchtxt.text = "$numberMatch"
            numberMatchWintxt.text = "$numberMatchWin"



            val userInput = inputNumber.text.toString()

            val userNumber = userInput.toIntOrNull()

            if (userNumber != null && userNumber in 1..6) {

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

                    imgDice.setImageResource(imgFaceDice)

                    if (randomNumber == userNumber) {
                        textOutput.text = "Complimenti hai vinto 😘!"
                        textOutput.setTextColor(Color.GREEN)
                        numberMatchWin++
                    } else {

                        textOutput.text = "Mi dispiace hai perso 😢 "
                        textOutput.setTextColor(Color.RED)
                    }

                    textNumber.text = "Numero uscito: $randomNumber"

                    btnPlay.isEnabled = true
                }

            } else {
                textOutput.text = "Inserisci un numero valido tra 1 e 6."

                btnPlay.isEnabled = true
            }
        })
    }


}
