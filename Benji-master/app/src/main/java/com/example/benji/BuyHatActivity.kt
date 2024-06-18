package com.example.benji

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.benji.MainActivity.Companion.hat
import com.example.benji.MainActivity.Companion.score

class BuyHatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buy_hat)

        val santaButton = findViewById<Button>(R.id.santaHatBuy)
        santaButton.setOnClickListener {
            hat.currentHat = "SANTA"
            score.addToScore(-10)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val tiaraButton = findViewById<Button>(R.id.tiaraHat)
        tiaraButton.setOnClickListener {
            hat.currentHat = "TIARA"
            score.addToScore(-15)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val partyButton = findViewById<Button>(R.id.partyHat)
        partyButton.setOnClickListener {
            hat.currentHat = "PARTY"
            score.addToScore(-5)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val bunnyButton = findViewById<Button>(R.id.bunnyHat)
        bunnyButton.setOnClickListener {
            hat.currentHat = "BUNNY"
            score.addToScore(-8)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val removeButton = findViewById<Button>(R.id.removeHat)
        removeButton.setOnClickListener {
            hat.currentHat = "NONE"
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}