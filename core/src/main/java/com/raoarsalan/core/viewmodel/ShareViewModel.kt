package com.raoarsalan.core.viewmodel

import androidx.lifecycle.ViewModel
import com.raoarsalan.domain.entity.response.SpotifyEntity

class ShareViewModel : ViewModel() {
    var track: SpotifyEntity.TracksList? = null
}