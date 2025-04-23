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
            // Ottieni il numero inserito dall'utente come stringa
            val userInput = inputNumber.text.toString()

            // Prova a convertire l'input in un numero intero
            val userNumber = userInput.toIntOrNull()

            // Verifica che l'input sia valido (un numero tra 1 e 6)
            if (userNumber != null && userNumber in 1..6) {

                // Mostra il Toast per "Dado lanciato..."
                Toast.makeText(this, "Dado lanciato...", Toast.LENGTH_SHORT).show()

                // Esegui il ritardo di 2 secondi per simulare il controllo
                GlobalScope.launch(Dispatchers.Main) {
                    delay(3000)  // Ritardo di 2 secondi

                    // Genera un numero casuale tra 1 e 6 (simula il lancio del dado)
                    val randomNumber = (1..6).random()

                    // Scegli l'immagine del dado in base al numero casuale
                    val imgFaceDice = when (randomNumber) {
                        1 -> R.drawable.dice_face_1
                        2 -> R.drawable.dice_face_2
                        3 -> R.drawable.dice_face_3
                        4 -> R.drawable.dice_face_4
                        5 -> R.drawable.dice_face_5
                        else -> R.drawable.dice_face_6
                    }

                    // Imposta l'immagine del dado sull'ImageView
                    imgDice.setImageResource(imgFaceDice)

                    // Mostra il risultato del controllo del numero
                    if (randomNumber == userNumber) {
                        // Se i numeri coincidono, visualizza "Complimenti hai vinto!"
                        textOutput.text = "Complimenti hai vinto!"
                        textOutput.setTextColor(Color.GREEN)
                        numberMatchWin++
                    } else {
                        // Se i numeri non coincidono, visualizza "Mi dispiace hai perso :("

                        textOutput.text = "Mi dispiace hai perso :("
                        textOutput.setTextColor(Color.RED)
                    }

                    // Mostra il numero che è uscito sul dado
                    textNumber.text = "Numero uscito: $randomNumber"

                    btnPlay.isEnabled = true
                }

            } else {
                // Se il numero inserito non è valido, mostra il messaggio di errore
                textOutput.text = "Inserisci un numero valido tra 1 e 6."

                btnPlay.isEnabled = true
            }
        })
    }
}
