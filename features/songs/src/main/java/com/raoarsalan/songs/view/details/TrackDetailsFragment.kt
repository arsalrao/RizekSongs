package com.raoarsalan.songs.view.details

import android.os.Bundle
import android.view.View
import com.raoarsalan.core.ui.base.BaseFragment
import com.raoarsalan.songs.BR
import com.raoarsalan.songs.R
import com.raoarsalan.songs.databinding.FragmentTrackDetailsBinding
import com.raoarsalan.songs.viewmodel.TrackDetailsViewModel


class TrackDetailsFragment :
    BaseFragment<TrackDetailsViewModel, FragmentTrackDetailsBinding>(TrackDetailsViewModel::class) {

    override val layoutRes: Int
        get() = R.layout.fragment_track_details
    override val bindingVariable: Int
        get() = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}