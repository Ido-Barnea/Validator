package com.barnea.validator.validations

class MaxLengthValidation(private val length: Int, private val error: String = "Text must be less than ${length + 1} characters long"): BaseValidation {
    override fun validate(text: String): Boolean = text.length <= length
    override fun errorMessage(): String = error
}