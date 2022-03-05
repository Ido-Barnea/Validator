package com.barnea.validator.validations

import android.util.Patterns

class ContainsLowercaseValidation(private val error: String = "Text must contain at least one lowercase character"): BaseValidation {
    override fun validate(text: String): Boolean = text.matches(Regex("(.*[a-z].*)"))
    override fun errorMessage(): String = error
}