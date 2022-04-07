package com.barnea.validator.validations

class OnlyLettersValidation(private val error: String = "Text cannot contain anything but letters"): BaseValidation {
    override fun validate(text: String): Boolean = text.matches(Regex("^[ A-Za-z]+\$"))
    override fun errorMessage(): String = error
}