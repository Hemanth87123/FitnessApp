package com.example.a227_app

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import kotlin.math.abs

class Skipping_Activity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private var isSkipping = false
    private var skipCount = 0
    private var lastY = 0f

    private lateinit var animationView: LottieAnimationView
    private lateinit var skipCountText: TextView
    private lateinit var startButton: Button
    private lateinit var stopButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skipping)

        // Initialize views
        animationView = findViewById(R.id.skippingAnimation)
        skipCountText = findViewById(R.id.skipCountText)
        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)

        // Initialize sensor manager and accelerometer
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        // Start button
        startButton.setOnClickListener {
            if (!isSkipping) {
                isSkipping = true
                skipCount = 0
                skipCountText.text = "Skips: $skipCount"
                animationView.playAnimation()
                sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
            }
        }

        // Stop button
        stopButton.setOnClickListener {
            if (isSkipping) {
                isSkipping = false
                animationView.pauseAnimation()
                sensorManager.unregisterListener(this)
            }
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (isSkipping && event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val y = event.values[1] // Detect vertical movement
            if (abs(y - lastY) > 6) { // Threshold for motion detection
                skipCount++
                skipCountText.text = "Skips: $skipCount"
            }
            lastY = y
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // No implementation needed
    }

    override fun onDestroy() {
        super.onDestroy()
        sensorManager.unregisterListener(this)
    }
}
