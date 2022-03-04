package com.barnea.validator.validations

class AllLowercaseValidation(private val error: String = "Text must be all lowercase"): BaseValidation {
    override fun validate(text: String): Boolean = text.lowercase() == text
    override fun errorMessage(): String = error
}