package com.barnea.validator.validations

import android.util.Patterns

class EmailValidation(private val error: String = "Illegal email"): BaseValidation {
    override fun validate(text: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(text).matches()
    override fun errorMessage(): String = error
}