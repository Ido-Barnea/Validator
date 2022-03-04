package com.barnea.validator.validations

class AllUppercaseValidation(private val error: String = "Text must be all uppercase"): BaseValidation {
    override fun validate(text: String): Boolean = text.uppercase() == text
    override fun errorMessage(): String = error
}