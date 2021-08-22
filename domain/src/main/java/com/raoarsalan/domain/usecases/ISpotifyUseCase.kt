package com.raoarsalan.domain.usecases

import com.raoarsalan.domain.common.ResultResponse
import com.raoarsalan.domain.entity.response.SpotifyEntity
import kotlinx.coroutines.flow.Flow

interface ISpotifyUseCase {
    fun searchSpotify(
        query: String,
        type: String,
        market: String?,
        limit: Int?,
        offSet: Int?
    ): Flow<ResultResponse<SpotifyEntity.Search>>
}