package com.barnea.validator.validations

class ContainsSubstringValidation(private val substring: String, private val error: String = "Text must contain '$substring'"): BaseValidation {
    override fun validate(text: String): Boolean = text.contains(substring)
    override fun errorMessage(): String = error
}