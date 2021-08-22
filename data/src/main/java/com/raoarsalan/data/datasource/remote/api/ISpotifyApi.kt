package com.raoarsalan.data.datasource.remote.api

import com.raoarsalan.data.datasource.remote.dto.SpotifyDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ISpotifyApi {
    @GET("/v1/search")
    suspend fun spotifySearch(
        @Query("q") query: String,
        @Query("type") type: String,
        @Query("market") market: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offSet: Int?,
    ): SpotifyDto.Search
}