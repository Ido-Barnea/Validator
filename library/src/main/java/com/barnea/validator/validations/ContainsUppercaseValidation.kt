package com.barnea.validator.validations

class ContainsUppercaseValidation(private val error: String = "Text must contain at least one uppercase character"): BaseValidation {
    override fun validate(text: String): Boolean = text.matches(Regex("(.*[A-Z].*)"))
    override fun errorMessage(): String = error
}