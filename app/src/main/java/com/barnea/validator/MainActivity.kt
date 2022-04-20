package com.barnea.validator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Validator("My Text") // Create a Validator object with your text
            .minLength(4, "Your text should be at least 4 characters long!") // Your Validations
            .maxLength(10, "Your text can't be longer than 10 characters!")
            .addCallback(object: ValidatorCallback {
                override fun onSuccess() {
                    // Text validated successfully
                }

                override fun onFailure(error: String) {
                    //Text did not pass validation tests
                }
            })
            .validate() // Required, returns a boolean
    }
}