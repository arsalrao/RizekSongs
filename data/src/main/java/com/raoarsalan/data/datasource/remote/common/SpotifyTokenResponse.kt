package com.raoarsalan.data.datasource.remote.common

import com.google.gson.annotations.SerializedName

data class SpotifyTokenResponse(

    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("expires_in")
    val expiresIn: Int,
    @SerializedName("error")
    val tokenError: TokenError? = null
)


data class TokenError(
    @SerializedName("error")
    val error: String? = null,
    @SerializedName("error_description")
    val errorDescription: String? = null
)
