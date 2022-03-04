package com.barnea.validator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import javax.xml.validation.Validator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Validator("My text")
            .notEmpty()
            .addFailureCallback {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
            .addSuccessCallback {
                Toast.makeText(this, "Succeeded", Toast.LENGTH_SHORT).show()
            }
            .validate()
    }
}