package com.example.benji

import android.animation.Animator
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.util.Date
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    companion object {
        val score = Score()
        val hat = Hats()
        var first_launch = true
        var tapCheckbox = false
        var lightCheckbox = false
        var plugCheckbox = false
        var compostCheckbox = false
        var gotExtraDailyPoints = false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (first_launch) {
            val sharedPref = getPreferences(Context.MODE_PRIVATE)
            val currentScore = sharedPref.getInt("currentScore", 0)
            val currentHat = sharedPref.getString("currentHat", "NONE")
            score.currentScore = currentScore
            hat.currentHat = currentHat
            gotExtraDailyPoints = sharedPref.getBoolean("gotExtraDailyPoints", false)
            if (LocalDate.now().toString() == sharedPref.getString("lastLogin", "None")) {
                tapCheckbox = sharedPref.getBoolean("tapCheckbox", false)
                lightCheckbox = sharedPref.getBoolean("lightCheckbox", false)
                plugCheckbox = sharedPref.getBoolean("plugCheckbox", false)
                compostCheckbox = sharedPref.getBoolean("compostCheckbox", false)
            }

            first_launch = false
        }

        val scoreboard = findViewById<TextView>(R.id.scoreboard)
        scoreboard.text = "SCORE : " + score.currentScore.toString()

        setIcebergImage()
        setHatImage()
        val icebergImage = findViewById<ImageView>(R.id.icebergImage)
        icebergImage.setOnClickListener { _ ->
            val polarBearText = findViewById<TextView>(R.id.polarBearText)
            val speech0 = listOf("please don't kill me..", "I'm drowning!", "HELP!")
            val speech2 = listOf("where's all the ice gone? :(", "the iceberg can't get any smaller!", "quick, this ice won't last much longer!")
            val speech4 = listOf("the ice is melting!", "remember your daily tasks to stop my iceberg from shrinking", "help save the planet!")
            val speech10 = listOf("keep going to save my home!", "remember to keep logging your tasks!", "it's getting a bit roomier now :)")
            val speechMore = listOf("thanks for keeping me alive! :D", "thank you for saving my home!", "you've done so well for the planet!")
            val randomIndex = Random.nextInt(0,3)
            if (score.currentScore < 0) {
                polarBearText.text = speech0[randomIndex]
            } else if (score.currentScore < 2) {
                polarBearText.text = speech2[randomIndex]
            } else if (score.currentScore < 4) {
                polarBearText.text = speech4[randomIndex]
            } else if (score.currentScore < 10) {
                polarBearText.text = speech10[randomIndex]
            } else {
                polarBearText.text = speechMore[randomIndex]
            }
            polarBearText.visibility = View.VISIBLE
            polarBearText.postDelayed(Runnable {
                run {
                    polarBearText.visibility = View.INVISIBLE
                }
            }, 3000)
        }

        val helpfulButtonClick = findViewById<ImageButton>(R.id.threeLines)
        helpfulButtonClick.setOnClickListener {
            val intent = Intent(this, HelpfulButtonsActivity::class.java)
            startActivity(intent)
        }

        val addTasksButtonClick = findViewById<ImageButton>(R.id.add)
        addTasksButtonClick.setOnClickListener {
            val intent = Intent(this, AddTasksDoneActivity::class.java)
            startActivity(intent)
        }

        // need to call this to save score on exit of program
        saveData()
    }
    private fun setIcebergImage() {
        val icebergImage = findViewById<ImageView>(R.id.icebergImage)
        if (score.currentScore < 0) {
            icebergImage.setImageResource(R.drawable.drowning)
        } else if (score.currentScore < 2) {
            icebergImage.setImageResource(R.drawable.iceberg_1)
        } else if (score.currentScore < 4) {
            icebergImage.setImageResource(R.drawable.iceberg_2)
        } else if (score.currentScore < 6) {
            icebergImage.setImageResource(R.drawable.iceberg_3)
        } else if (score.currentScore < 8) {
            icebergImage.setImageResource(R.drawable.iceberg_4)
        } else if (score.currentScore < 10) {
            icebergImage.setImageResource(R.drawable.iceberg_5)
        } else if (score.currentScore < 12) {
            icebergImage.setImageResource(R.drawable.iceberg_6)
        } else if (score.currentScore < 14) {
            icebergImage.setImageResource(R.drawable.iceberg_7)
        } else {
            icebergImage.setImageResource(R.drawable.iceberg_8)
        }
    }

    private fun setHatImage() {
        val hatImage = findViewById<ImageView>(R.id.hatImage)
        if (hat.currentHat == "SANTA") {
            hatImage.setImageResource(R.drawable.santahat_removebg_preview)
        } else if (hat.currentHat == "TIARA") {
            hatImage.setImageResource(R.drawable.tiara_removebg_preview)
        } else if (hat.currentHat == "PARTY") {
            hatImage.setImageResource(R.drawable.party_hat_removebg_preview)
        } else if (hat.currentHat == "BUNNY") {
            hatImage.setImageResource(R.drawable.bunny_ears_removebg_preview)
        }
    }

    private fun saveData() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPreferences.edit()) {
            putInt("currentScore", score.currentScore)
            putString("currentHat", hat.currentHat)
            putString("lastLogin", LocalDate.now().toString())
            putBoolean("tapCheckbox", tapCheckbox)
            putBoolean("lightCheckbox", lightCheckbox)
            putBoolean("plugCheckbox", plugCheckbox)
            putBoolean("compostCheckbox", compostCheckbox)
            putBoolean("gotExtraDailyPoints", gotExtraDailyPoints)
            apply()
        }
    }

}
