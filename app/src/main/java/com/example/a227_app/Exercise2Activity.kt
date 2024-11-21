package com.example.a227_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class Exercise2Activity : AppCompatActivity() {

    private lateinit var animationView: LottieAnimationView
    private lateinit var timerDisplay: TextView
    private var timer: CountDownTimer? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise2)

        animationView = findViewById(R.id.exerciseAnimation)
        timerDisplay = findViewById(R.id.timerDisplay)

        animationView.setAnimation(R.raw.tplank)
        animationView.playAnimation()

        findViewById<TextView>(R.id.exerciseName).text = "T Plank"

        findViewById<Button>(R.id.timer5Sec).setOnClickListener { startTimer(5000) }
        findViewById<Button>(R.id.timer10Sec).setOnClickListener { startTimer(10000) }
        findViewById<Button>(R.id.timer15Sec).setOnClickListener { startTimer(15000) }
    }

    private fun startTimer(duration: Long) {
        timer?.cancel()
        animationView.playAnimation()

        timer = object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = (millisUntilFinished / 1000).toInt()
                timerDisplay.text = String.format("00:%02d", seconds)
            }

            override fun onFinish() {
                animationView.pauseAnimation()
                timerDisplay.text = "00:00"
                Toast.makeText(this@Exercise2Activity, "Well Done!", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}
