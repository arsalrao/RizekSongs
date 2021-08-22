package com.raoarsalan.songs.viewmodel

import androidx.lifecycle.viewModelScope
import com.raoarsalan.core.viewmodel.BaseViewModel
import com.raoarsalan.domain.common.ResultResponse
import com.raoarsalan.domain.entity.response.ErrorEntity
import com.raoarsalan.domain.usecases.ISpotifyUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchTrackViewModel constructor(private val spotifyUseCase: ISpotifyUseCase) :
    BaseViewModel() {


    init {
        searchSpotify(
            "atif",
            "track,artist",
            "US",
            10,
            5
        )
    }

    fun searchSpotify(
        query: String,
        type: String,
        market: String?,
        limit: Int?,
        offSet: Int?
    ) {
        // scoresList.clear()
        //  showLoading(true)

        viewModelScope.launch {
            spotifyUseCase.searchSpotify(query, type, market, limit, offSet).collect {
                if (it is ResultResponse.Success) {
                    setError(error = ErrorEntity.Error(12, "succes"))

                } else {
                    setError(error = (it as ResultResponse.Error).error)
                }
            }
        }
    }

}