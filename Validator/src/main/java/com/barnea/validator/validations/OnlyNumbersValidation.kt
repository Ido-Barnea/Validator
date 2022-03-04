package com.barnea.validator.validations

class OnlyNumbersValidation(private val error: String = "Text cannot contain anything but numbers"): BaseValidation {
    override fun validate(text: String): Boolean = text.matches(Regex("^[ 0-9]+\$"))
    override fun errorMessage(): String = error
}