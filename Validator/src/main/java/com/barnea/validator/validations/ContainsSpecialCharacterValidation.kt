package com.barnea.validator.validations

class ContainsSpecialCharacterValidation(private val error: String = "Text must contain at least one special character"): BaseValidation {
    override fun validate(text: String): Boolean = text.matches(Regex("(.*\\W.*)"))
    override fun errorMessage(): String = error
}