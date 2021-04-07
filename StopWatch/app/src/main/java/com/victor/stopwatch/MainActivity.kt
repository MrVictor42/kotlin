package com.victor.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.victor.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var running = false
    private var pause: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val startBtn = binding.start
        val pauseBtn = binding.pause
        val resetBtn = binding.reset

        startBtn.setOnClickListener {
            startStopWatch()
        }

        pauseBtn.setOnClickListener {
            pauseStopWatch()
        }

        resetBtn.setOnClickListener {
            resetStopWatch()
        }
    }

    private fun startStopWatch() {
        if(!running) {
            binding.stopwatch.base = SystemClock.elapsedRealtime() - pause
            binding.stopwatch.start()
            running = true
        }
    }

    private fun pauseStopWatch() {
        if(running) {
            binding.stopwatch.stop()
            pause = SystemClock.elapsedRealtime() - binding.stopwatch.base
            running = false
        }
    }

    private fun resetStopWatch() {
        binding.stopwatch.base = SystemClock.elapsedRealtime()
        pause = 0
    }
}