package com.example.benji

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.benji.MainActivity.Companion.score

class HelpfulButtonsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.helpful_buttons_page)

        val timeShowerButton = findViewById<Button>(R.id.time_shower_button)
        timeShowerButton.setOnClickListener {
            val intent = Intent(this, TimeShowerActivity::class.java)
            startActivity(intent)
        }

        val dailyTasksButton = findViewById<Button>(R.id.daily_task_button)
        dailyTasksButton.setOnClickListener {
            val intent = Intent(this, DailyTasksActivity::class.java)
            startActivity(intent)
        }

        val buyHatButton = findViewById<Button>(R.id.buy_hat_button)
        buyHatButton.setOnClickListener {
            val intent = Intent(this, BuyHatActivity::class.java)
            startActivity(intent)
        }

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}