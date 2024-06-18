package com.example.benji

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.benji.MainActivity.Companion.score
import com.example.benji.MainActivity.Companion

class DailyTasksActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daily_tasks)

        val tapCheckbox = findViewById<CheckBox>(R.id.tapOff)
        val lightCheckbox = findViewById<CheckBox>(R.id.lightOff)
        val plugCheckbox = findViewById<CheckBox>(R.id.plugSockets)
        val compostCheckbox = findViewById<CheckBox>(R.id.compostFood)
        val extraPointsText = findViewById<TextView>(R.id.extraPointsText)

        tapCheckbox.isChecked = Companion.tapCheckbox
        lightCheckbox.isChecked = Companion.lightCheckbox
        plugCheckbox.isChecked = Companion.plugCheckbox
        compostCheckbox.isChecked = Companion.compostCheckbox

        tapCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                score.addToScore(1)
            } else {
                score.addToScore(-1)
            }
            if (tapCheckbox.isChecked && lightCheckbox.isChecked
                    && plugCheckbox.isChecked && compostCheckbox.isChecked) {
                extraPointsText.visibility = View.VISIBLE
                extraPointsText.postDelayed(Runnable {
                    run {
                        extraPointsText.visibility = View.INVISIBLE
                    }
                }, 3000)
            }
            Companion.tapCheckbox = isChecked
        }

        lightCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                score.addToScore(1)
            } else {
                score.addToScore(-1)
            }
            if (tapCheckbox.isChecked && lightCheckbox.isChecked
                    && plugCheckbox.isChecked && compostCheckbox.isChecked) {
                extraPointsText.visibility = View.VISIBLE
                extraPointsText.postDelayed(Runnable {
                    run {
                        extraPointsText.visibility = View.INVISIBLE
                    }
                }, 3000)
            }
            Companion.lightCheckbox = isChecked
        }

        plugCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                score.addToScore(1)
            } else {
                score.addToScore(-1)
            }
            if (tapCheckbox.isChecked && lightCheckbox.isChecked
                    && plugCheckbox.isChecked && compostCheckbox.isChecked) {
                extraPointsText.visibility = View.VISIBLE
                extraPointsText.postDelayed(Runnable {
                    run {
                        extraPointsText.visibility = View.INVISIBLE
                    }
                }, 3000)
            }
            Companion.plugCheckbox = isChecked
        }

        compostCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                score.addToScore(1)
            } else {
                score.addToScore(-1)
            }
            if (tapCheckbox.isChecked && lightCheckbox.isChecked
                    && plugCheckbox.isChecked && compostCheckbox.isChecked) {
                extraPointsText.visibility = View.VISIBLE
                extraPointsText.postDelayed(Runnable {
                    run {
                        extraPointsText.visibility = View.INVISIBLE
                    }
                }, 3000)
            }
            Companion.compostCheckbox = isChecked
        }

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            if (!Companion.gotExtraDailyPoints && tapCheckbox.isChecked && lightCheckbox.isChecked
                    && plugCheckbox.isChecked && compostCheckbox.isChecked) {
                score.addToScore(2)
                Companion.gotExtraDailyPoints = true
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}