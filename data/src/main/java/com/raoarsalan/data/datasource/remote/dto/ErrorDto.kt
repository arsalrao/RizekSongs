package com.raoarsalan.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName


sealed class ErrorDto {

    data class ErrorResponse(@SerializedName("error") val error: Error? = null)

    data class Error(
        @SerializedName("status") val status: Int,
        @SerializedName("message") val errorMsg: String
    )


}
