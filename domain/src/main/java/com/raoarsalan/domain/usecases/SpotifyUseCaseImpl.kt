package com.raoarsalan.domain.usecases

import com.raoarsalan.domain.common.ResultResponse
import com.raoarsalan.domain.entity.response.SpotifyEntity
import com.raoarsalan.domain.repo.ISpotifyRepo
import kotlinx.coroutines.flow.Flow

class SpotifyUseCaseImpl constructor(private val spotifyRepo: ISpotifyRepo) : ISpotifyUseCase {

    override fun searchSpotify(
        query: String,
        type: String,
        market: String?,
        limit: Int?,
        offSet: Int?
    ): Flow<ResultResponse<SpotifyEntity.Search>> {

        return spotifyRepo.searchSpotify(query, type, market, limit, offSet)
    }


}