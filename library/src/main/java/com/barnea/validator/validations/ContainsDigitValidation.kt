package com.barnea.validator.validations

class ContainsDigitValidation(private val error: String = "Text must contain at least one digit"): BaseValidation {
    override fun validate(text: String): Boolean = text.matches(Regex("(.*\\d.*)"))
    override fun errorMessage(): String = error
}