package com.barnea.validator.validations

import android.util.Patterns

class PhoneValidator(private val error: String = "Illegal phone number"): BaseValidation {
    override fun validate(text: String): Boolean = Patterns.PHONE.matcher(text).matches()
    override fun errorMessage(): String = error
}