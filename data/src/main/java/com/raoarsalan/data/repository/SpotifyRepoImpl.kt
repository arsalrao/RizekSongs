package com.raoarsalan.data.repository

import com.raoarsalan.data.datasource.remote.api.ISpotifyApi
import com.raoarsalan.domain.common.ResultResponse
import com.raoarsalan.domain.entity.response.SpotifyEntity
import com.raoarsalan.domain.repo.ISpotifyRepo
import kotlinx.coroutines.flow.Flow

class SpotifyRepoImpl(private val spotifyApi: ISpotifyApi) : ISpotifyRepo {

    override fun searchSpotify(
        query: String,
        type: String,
        market: String?,
        limit: Int?,
        offSet: Int?
    ): Flow<ResultResponse<SpotifyEntity.Search>> {
        TODO("Not yet implemented")
    }
}