package com.barnea.validator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Validator("My text") // Create a Validator object with your text
            .notEmpty() // Your Validations
            .minLength(4, "Your text should be at least 4 characters long!")
            .addCallback(object: ValidatorCallback {
                override fun onSuccess() {
                    Toast.makeText(this@MainActivity, "Succeeded", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(error: String) {
                    Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
                }
            })
            .validate() // Required, returns a boolean
    }
}