package com.raoarsalan.data.datasource.remote.api

import com.raoarsalan.data.datasource.remote.common.SpotifyTokenResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ITokenApi {
    @FormUrlEncoded
    @POST("/api/token")
    fun getToken(
        @Field("grant_type") grantType: String = "client_credentials",
        @Field("client_id") clint_id: String = "c07b3ffbc52c4e3d94c03fd27107f5aa",
        @Field("client_secret") clientSecret: String = "d51a8bc9cf2a423c846b2dc66d875497"
    ): Call<SpotifyTokenResponse>
}