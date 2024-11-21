package com.example.a227_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainScreenActivity : AppCompatActivity() {

    private var areOptionsVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val mainFab = findViewById<FloatingActionButton>(R.id.mainFab)
        val fabGymNearMe = findViewById<FloatingActionButton>(R.id.fabGymNearMe)
        val optionFab1 = findViewById<FloatingActionButton>(R.id.optionFab1)
        val optionFab2 = findViewById<FloatingActionButton>(R.id.optionFab2)

        fabGymNearMe.visibility = View.GONE
        optionFab1.visibility = View.GONE
        optionFab2.visibility = View.GONE

        mainFab.setOnClickListener {
            toggleFabOptions(fabGymNearMe, optionFab1, optionFab2)
        }

        fabGymNearMe.setOnClickListener {
            val intent = Intent(this, GymNearMeActivity::class.java) // Replace with actual activity
            startActivity(intent)
        }

        optionFab1.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        optionFab2.setOnClickListener {
            val intent = Intent(this, MealPlanActivity::class.java)
            startActivity(intent)
        }

        findViewById<CardView>(R.id.cardExercise1).setOnClickListener {
            val intent = Intent(this, Exercise1Activity::class.java)
            startActivity(intent)
        }
        findViewById<CardView>(R.id.cardExercise2).setOnClickListener {
            val intent = Intent(this, Exercise2Activity::class.java)
            startActivity(intent)
        }
        findViewById<CardView>(R.id.cardExercise3).setOnClickListener {
            val intent = Intent(this, Exercise3Activity::class.java)
            startActivity(intent)
        }
        findViewById<CardView>(R.id.cardExercise4).setOnClickListener {
            val intent = Intent(this, Skipping_Activity::class.java)
            startActivity(intent)
        }
    }

    private fun toggleFabOptions(vararg fabs: FloatingActionButton) {
        areOptionsVisible = !areOptionsVisible
        for (fab in fabs) {
            fab.visibility = if (areOptionsVisible) View.VISIBLE else View.GONE
        }
    }
}
