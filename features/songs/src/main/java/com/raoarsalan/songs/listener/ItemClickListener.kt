package com.raoarsalan.songs.listener

import com.raoarsalan.domain.entity.response.SpotifyEntity

interface ItemClickListener {

    fun itemSelect(track: SpotifyEntity.TracksList)
}