package com.barnea.validator

import com.barnea.validator.validations.*

class Validator(private val text: String) {

    private val validationsList = ArrayList<BaseValidation>()
    private var errorMessage: String = ""

    private var failureCallback: ((errorMessage: String) -> Unit)? = null
    private var successCallback: (() -> Unit)? = null

    fun validate(): Boolean {
        for (validation in validationsList){
            if (!validation.validate(text)){
                setError(validation.errorMessage())
                failureCallback?.invoke(errorMessage)
                return false
            }
        }

        successCallback?.invoke()
        return true
    }

    private fun addValidation(validation: BaseValidation): Validator {
        validationsList.add(validation)
        return this
    }

    private fun setError(errorMessage: String): Validator {
        this.errorMessage = errorMessage
        return this
    }

    fun addFailureCallback(callback: (errorMessage: String) -> Unit): Validator {
        failureCallback = callback
        return this
    }

    fun addSuccessCallback(callback: () -> Unit):  Validator {
        successCallback = callback
        return this
    }

    // Validations
    fun notEmpty(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { NotEmptyValidation(it) }?: NotEmptyValidation()
        addValidation(validation)
        return this
    }

    fun minLength(length: Int, errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { MinLengthValidation(length, it) }?: MinLengthValidation(length)
        addValidation(validation)
        return this
    }

    fun maxLength(length: Int, errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { MaxLengthValidation(length, it) }?: MaxLengthValidation(length)
        addValidation(validation)
        return this
    }

    fun containsSubstring(character: String, errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { ContainsSubstringValidation(character, it) }?: ContainsSubstringValidation(character)
        addValidation(validation)
        return this
    }

    fun email(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { EmailValidation(it) }?: EmailValidation()
        addValidation(validation)
        return this
    }

    fun phone(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { PhoneValidator(it) }?: PhoneValidator()
        addValidation(validation)
        return this
    }

    fun onlyLetters(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { OnlyLettersValidation(it) }?: OnlyLettersValidation()
        addValidation(validation)
        return this
    }

    fun onlyNumbers(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { OnlyNumbersValidation(it) }?: OnlyNumbersValidation()
        addValidation(validation)
        return this
    }

    fun allLowercase(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { AllLowercaseValidation(it) }?: AllLowercaseValidation()
        addValidation(validation)
        return this
    }

    fun allUppercase(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { AllUppercaseValidation(it) }?: AllUppercaseValidation()
        addValidation(validation)
        return this
    }
}