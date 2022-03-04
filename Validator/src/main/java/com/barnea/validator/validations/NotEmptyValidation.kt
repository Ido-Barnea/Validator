package com.barnea.validator.validations

import android.util.Patterns

class NotEmptyValidation(private val error: String = "Text cannot be empty"): BaseValidation {
    override fun validate(text: String): Boolean = text.isNotBlank()
    override fun errorMessage(): String = error
}