package com.barnea.validator.validations

import android.util.Patterns

class PhoneValidator(private val error: String = "Illegal phone number"): BaseValidation {
    override fun validate(text: String): Boolean = text.matches(Regex("^[+]?[0-9]{10,13}\$"))
    override fun errorMessage(): String = error
}