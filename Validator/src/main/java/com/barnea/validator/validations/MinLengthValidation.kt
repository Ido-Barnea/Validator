package com.barnea.validator.validations

class MinLengthValidation(private var length: Int, private var error: String = "Text must be at least $length characters long"): BaseValidation {
    override fun validate(text: String): Boolean = text.length >= length
    override fun errorMessage(): String = error
}