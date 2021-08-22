package com.raoarsalan.data.util

import android.util.MalformedJsonException
import com.google.gson.GsonBuilder
import com.raoarsalan.data.common.NetworkConstants
import com.raoarsalan.data.datasource.remote.dto.ErrorDto
import com.raoarsalan.domain.common.ResultResponse
import com.raoarsalan.domain.entity.response.ErrorEntity
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import java.io.InterruptedIOException
import java.net.SocketException
import java.net.SocketTimeoutException


suspend fun <T : Any> apiCall(call: suspend () -> T): ResultResponse<T> {
    return try {
        val response = call()
        ResultResponse.Success(response)
    } catch (ex: Throwable) {
        ResultResponse.Error(handleError(ex))
    }
}

private fun handleError(throwable: Throwable): ErrorEntity.Error {
    return when (throwable) {
        is SocketTimeoutException, is SocketException, is InterruptedIOException -> {

            ErrorEntity.Error(
                NetworkConstants.NETWORK_ERROR_CODES.SERVICE_UNAVAILABLE,
                NetworkConstants.NETWORK_ERROR_MESSAGES.SERVICE_UNAVAILABLE
            )

        }

        is MalformedJsonException -> {
            ErrorEntity.Error(
                NetworkConstants.NETWORK_ERROR_CODES.MALFORMED_JSON,
                NetworkConstants.NETWORK_ERROR_MESSAGES.MALFORMED_JSON
            )
        }
        is IOException -> {
            ErrorEntity.Error(
                NetworkConstants.NETWORK_ERROR_CODES.NO_INTERNET,
                NetworkConstants.NETWORK_ERROR_MESSAGES.NO_INTERNET
            )
        }

        is HttpException -> {

            val errorResponse: ErrorDto.ErrorResponse? =
                getError(throwable.response()?.errorBody())
            if (errorResponse?.error == null) {
                ErrorEntity.Error(
                    NetworkConstants.NETWORK_ERROR_CODES.UNEXPECTED_ERROR,
                    NetworkConstants.NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR
                )
            } else {

                ErrorEntity.Error(
                    errorResponse.error.status,
                    errorResponse.error.errorMsg
                )
            }
        }
        else -> {
            ErrorEntity.Error(
                NetworkConstants.NETWORK_ERROR_CODES.UNEXPECTED_ERROR,
                NetworkConstants.NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR
            )
        }
    }

}

/**
 * This method serializes the errorbody to ErrorDto class
 */
private fun getError(responseBody: ResponseBody?): ErrorDto.ErrorResponse? {
    return try {
        val response = GsonBuilder().create()
            .fromJson(responseBody?.string(), ErrorDto.ErrorResponse::class.java)
        response
    } catch (ex: Exception) {
        ErrorDto.ErrorResponse(
            ErrorDto.Error(
                NetworkConstants.NETWORK_ERROR_CODES.UNEXPECTED_ERROR,
                NetworkConstants.NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR
            )
        )
    }
}
