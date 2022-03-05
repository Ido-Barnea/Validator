package com.barnea.validator.validations

class MinLengthValidation(private val length: Int, private val error: String = "Text must be at least $length characters long"): BaseValidation {
    override fun validate(text: String): Boolean = text.length >= length
    override fun errorMessage(): String = error
}