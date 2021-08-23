package com.raoarsalan.songs.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.viewModelScope
import com.raoarsalan.core.utils.NavigationCommand
import com.raoarsalan.core.viewmodel.BaseViewModel
import com.raoarsalan.domain.common.ResultResponse
import com.raoarsalan.domain.entity.response.SpotifyEntity
import com.raoarsalan.domain.usecases.ISpotifyUseCase
import com.raoarsalan.songs.BR
import com.raoarsalan.songs.R
import com.raoarsalan.songs.listener.ItemClickListener
import com.raoarsalan.songs.view.search.SearchTracksFragmentDirections
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.tatarka.bindingcollectionadapter2.ItemBinding

class SearchTrackViewModel constructor(private val spotifyUseCase: ISpotifyUseCase) :

    BaseViewModel(), ItemClickListener {

    val trackList = ObservableArrayList<SpotifyEntity.TracksList>()
    val itemBinding: ItemBinding<SpotifyEntity.TracksList> =
        ItemBinding.of<SpotifyEntity.TracksList>(
            BR.itemViewModel,
            R.layout.item_search
        ).bindExtra(BR.listener, this)



    fun searchSpotify(
        query: String,
        type: String = "track,artist",
        market: String? = "US",
        limit: Int? = 20,
        offSet: Int? = 5
    ) {
        trackList.clear()
        showLoading(true)
        setNoData(false)
        setQuery(query)

        viewModelScope.launch {
            spotifyUseCase.searchSpotify(query, type, market, limit, offSet).collect {
                if (it is ResultResponse.Success) {
                    val track = it.data.tracks
                    showLoading(false)
                    trackList.addAll(
                        track.items ?: emptyList()
                    )
                    setNoData(track.total == 0)
                } else {
                    showLoading(false)
                    setError(error = (it as ResultResponse.Error).error)
                }
            }
        }
    }

    override fun itemSelect(track: SpotifyEntity.TracksList) {
        sharedViewModel.track = track
        navigationCommands.value = NavigationCommand.To(
            SearchTracksFragmentDirections.actionSearchTrackFragmentToDetailFragment()
        )


    }


}