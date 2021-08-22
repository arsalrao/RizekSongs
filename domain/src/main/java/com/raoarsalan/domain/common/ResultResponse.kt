package com.raoarsalan.domain.common

import com.raoarsalan.domain.entity.response.ErrorEntity

sealed class ResultResponse<T> {

    data class Success<T>(val data: T) : ResultResponse<T>()

    data class Error<T>(val error: ErrorEntity.Error?) : ResultResponse<T>()
}
