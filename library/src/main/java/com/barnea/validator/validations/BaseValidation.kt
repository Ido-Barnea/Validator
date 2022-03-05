package com.barnea.validator.validations

interface BaseValidation {

  fun validate(text: String): Boolean
  fun errorMessage(): String

}