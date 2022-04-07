package com.barnea.validator

interface ValidatorCallback {

    fun onSuccess()
    fun onFailure(error: String)

}