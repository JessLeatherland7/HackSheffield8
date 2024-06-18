package com.example.benji

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.benji.MainActivity.Companion.score

class AddTasksDoneActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_tasks_done)

        val backButtonClick = findViewById<Button>(R.id.backButton)
        backButtonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val publicTransportClick = findViewById<Button>(R.id.publicTrans)
        publicTransportClick.setOnClickListener {
            score.addToScore(1)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val clothesOutsideClick = findViewById<Button>(R.id.clothesOutside)
        clothesOutsideClick.setOnClickListener {
            score.addToScore(1)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val droveClick = findViewById<Button>(R.id.drove)
        droveClick.setOnClickListener {
            score.addToScore(-1)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val dryerUsedClick = findViewById<Button>(R.id.dryerUsed)
        dryerUsedClick.setOnClickListener {
            score.addToScore(-1)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val lightOnClick = findViewById<Button>(R.id.lightOn)
        lightOnClick.setOnClickListener {
            score.addToScore(-1)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}