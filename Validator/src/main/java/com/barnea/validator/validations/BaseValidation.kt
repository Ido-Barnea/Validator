package com.barnea.validator.validations

interface BaseValidation {

  /**
   * @param text The text to validate
   * @return true if the text validations passes, false otherwise
   */
  fun validate(text: String): Boolean

  /**
   * @return The reason why the validation failed
   */
  fun errorMessage(): String

}