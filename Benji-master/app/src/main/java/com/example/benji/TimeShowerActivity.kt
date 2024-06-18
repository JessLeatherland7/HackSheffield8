package com.example.benji

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.benji.databinding.TimeShowerBinding
import kotlin.math.roundToInt
import com.example.benji.MainActivity.Companion.score

class TimeShowerActivity : ComponentActivity() {

    private lateinit var binding: TimeShowerBinding
    private var timerStarted = false
    private lateinit var serviceIntent: Intent
    private var time = 0.0
    private var tStart = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TimeShowerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startStopButton.setOnClickListener {
            startStopTimer()
        }
        binding.resetButton.setOnClickListener {
            resetTimer()
        }

        serviceIntent = Intent(applicationContext, TimerService:: class.java)
        registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
    }


    private fun resetTimer() {
        stopTimer()
        time = 0.0
        binding.timeTV.text = getTimerStringFromDouble(time)
    }

    private fun startStopTimer() {
        if(timerStarted)
            stopTimer()
        else
            startTimer()
    }

    private fun startTimer() {
        serviceIntent.putExtra(TimerService.TIME_EXTRA, time)
        startService(serviceIntent)
        binding.startStopButton.text = "Stop"
        timerStarted = true
        tStart = System.currentTimeMillis()

    }

    private fun stopTimer() {
        stopService((serviceIntent))
        binding.startStopButton.text = "Start"
        timerStarted = false
        var tEnd = System.currentTimeMillis()
        var tDelta = tEnd - tStart
        var elapsedSeconds = tDelta / 1000.0
        if (elapsedSeconds < 900) {
            score.addToScore(2)
        }
        else if (elapsedSeconds > 1800) {
            score.addToScore(-2)
        }
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private val updateTime: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            time = intent.getDoubleExtra(TimerService.TIME_EXTRA, 0.0)
            binding.timeTV.text = getTimerStringFromDouble(time)
        }
    }

    private fun getTimerStringFromDouble(time: Double): String {
        val resultInt = time.roundToInt()
        val minutes = resultInt % 86400 % 3600 / 60
        val seconds = resultInt % 86400 % 3600 % 60

        return makeTimeString(minutes, seconds)
    }

    private fun makeTimeString(min: Int, sec: Int): String = String.format("%2d:%2d", min, sec)
}