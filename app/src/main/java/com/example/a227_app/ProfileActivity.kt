package com.example.a227_app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var inputName: EditText
    private lateinit var inputHeight: EditText
    private lateinit var inputWeight: EditText
    private lateinit var inputAge: EditText
    private lateinit var submitButton: Button
    private lateinit var displaySection: View
    private lateinit var nameDisplay: TextView
    private lateinit var heightDisplay: TextView
    private lateinit var weightDisplay: TextView
    private lateinit var ageDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Initialize views
        inputName = findViewById(R.id.inputName)
        inputHeight = findViewById(R.id.inputHeight)
        inputWeight = findViewById(R.id.inputWeight)
        inputAge = findViewById(R.id.inputAge)
        submitButton = findViewById(R.id.submitButton)
        displaySection = findViewById(R.id.displaySection)
        nameDisplay = findViewById(R.id.nameDisplay)
        heightDisplay = findViewById(R.id.heightDisplay)
        weightDisplay = findViewById(R.id.weightDisplay)
        ageDisplay = findViewById(R.id.ageDisplay)

        displaySection.visibility = View.GONE

        submitButton.setOnClickListener {
            val name = inputName.text.toString().trim()
            val height = inputHeight.text.toString().trim()
            val weight = inputWeight.text.toString().trim()
            val age = inputAge.text.toString().trim()

            if (name.isNotEmpty() && height.isNotEmpty() && weight.isNotEmpty() && age.isNotEmpty()) {
                nameDisplay.text = "Name: $name"
                heightDisplay.text = "Height: $height cm"
                weightDisplay.text = "Weight: $weight kg"
                ageDisplay.text = "Age: $age years"

                displaySection.visibility = View.VISIBLE

                inputName.text.clear()
                inputHeight.text.clear()
                inputWeight.text.clear()
                inputAge.text.clear()

                Toast.makeText(this, "Data submitted successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill in all the fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
