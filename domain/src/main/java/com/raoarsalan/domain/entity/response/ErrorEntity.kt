package com.raoarsalan.domain.entity.response

sealed class ErrorEntity {
    data class Error(val errorCode: Any?, val errorMessage: String? = "") : ErrorEntity()

}
