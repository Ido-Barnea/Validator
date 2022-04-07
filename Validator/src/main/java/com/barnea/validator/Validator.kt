package com.barnea.validator

import com.barnea.validator.validations.*

class Validator(private val text: String) {

    private val validationsList = ArrayList<BaseValidation>()
    private var errorMessage: String = ""

    private var validatorCallback: ValidatorCallback? = null

    /**
     * @return true of all validations in validationsList pass, false otherwise
     */
    fun validate(): Boolean {
        for (validation in validationsList){
            if (!validation.validate(text)){
                setError(validation.errorMessage())
                validatorCallback?.onFailure(errorMessage)
                return false
            }
        }

        validatorCallback?.onSuccess()
        return true
    }

    /**
     * @param validation The Validation object to add to the validationsList
     * @return Validator object
     */
    private fun addValidation(validation: BaseValidation): Validator {
        validationsList.add(validation)
        return this
    }

    /**
     * @param errorMessage The message displayed in case the validation is false
     * @return Validator object
     */
    private fun setError(errorMessage: String): Validator {
        this.errorMessage = errorMessage
        return this
    }

    /**
     * Sets the callback
     * @return Validator object
     */
    fun addCallback(callback: ValidatorCallback): Validator {
        validatorCallback = callback
        return this
    }

    // Validations
    /**
     * @param errorMessage the message returned in case the validation is false (uses default class value if not specified)
     * @return Validator object
     */
    fun notEmpty(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { NotEmptyValidation(it) }?: NotEmptyValidation()
        addValidation(validation)
        return this
    }

    /**
     * @param length the minimum length of the text
     * @param errorMessage the message returned in case the validation is false (uses default class value if not specified)
     * @return Validator object
     */
    fun minLength(length: Int, errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { MinLengthValidation(length, it) }?: MinLengthValidation(length)
        addValidation(validation)
        return this
    }

    /**
     * * @param length the maximum length of the text
     * @param errorMessage the message returned in case the validation is false (uses default class value if not specified)
     * @return Validator object
     */
    fun maxLength(length: Int, errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { MaxLengthValidation(length, it) }?: MaxLengthValidation(length)
        addValidation(validation)
        return this
    }

    /**
     * @param substring the string that should be in the text
     * @param errorMessage the message returned in case the validation is false (uses default class value if not specified)
     * @return Validator object
     */
    fun containsSubstring(substring: String, errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { ContainsSubstringValidation(substring, it) }?: ContainsSubstringValidation(substring)
        addValidation(validation)
        return this
    }

    /**
     * @param errorMessage the message returned in case the validation is false (uses default class value if not specified)
     * @return Validator object
     */
    fun email(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { EmailValidation(it) }?: EmailValidation()
        addValidation(validation)
        return this
    }

    /**
     * @param errorMessage the message returned in case the validation is false (uses default class value if not specified)
     * @return Validator object
     */
    fun phone(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { PhoneValidator(it) }?: PhoneValidator()
        addValidation(validation)
        return this
    }

    /**
     * @param errorMessage the message returned in case the validation is false (uses default class value if not specified)
     * @return Validator object
     */
    fun onlyLetters(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { OnlyLettersValidation(it) }?: OnlyLettersValidation()
        addValidation(validation)
        return this
    }

    /**
     * @param errorMessage the message returned in case the validation is false (uses default class value if not specified)
     * @return Validator object
     */
    fun onlyNumbers(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { OnlyNumbersValidation(it) }?: OnlyNumbersValidation()
        addValidation(validation)
        return this
    }

    /**
     * @param errorMessage the message returned in case the validation is false (uses default class value if not specified)
     * @return Validator object
     */
    fun containsLowercase(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { ContainsLowercaseValidation(it) }?: ContainsLowercaseValidation()
        addValidation(validation)
        return this
    }

    /**
     * @param errorMessage the message returned in case the validation is false (uses default class value if not specified)
     * @return Validator object
     */
    fun containsUppercase(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { ContainsUppercaseValidation(it) }?: ContainsUppercaseValidation()
        addValidation(validation)
        return this
    }

    /**
     * @param errorMessage the message returned in case the validation is false (uses default class value if not specified)
     * @return Validator object
     */
    fun containsDigit(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { ContainsDigitValidation(it) }?: ContainsDigitValidation()
        addValidation(validation)
        return this
    }

    /**
     * @param errorMessage the message returned in case the validation is false (uses default class value if not specified)
     * @return Validator object
     */
    fun containsSpecial(errorMessage: String? = null): Validator {
        val validation = errorMessage?.let { ContainsSpecialCharacterValidation(it) }?: ContainsSpecialCharacterValidation()
        addValidation(validation)
        return this
    }
}