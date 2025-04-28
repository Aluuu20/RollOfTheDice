package com.example.rollofthedice

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.ImageButton

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<ImageButton>(R.id.idbtnSwitch)
        buttonClick.setOnClickListener {
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }

         // val textView = findViewById<TextView>(R.id.idtitolo)

        }
    }
