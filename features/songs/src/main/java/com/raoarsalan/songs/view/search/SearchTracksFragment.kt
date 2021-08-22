package com.raoarsalan.songs.view.search

import android.os.Bundle
import android.view.View
import com.raoarsalan.core.ui.base.BaseFragment
import com.raoarsalan.songs.BR
import com.raoarsalan.songs.R
import com.raoarsalan.songs.databinding.FragmentSearchBinding
import com.raoarsalan.songs.viewmodel.SearchTrackViewModel

class SearchTracksFragment :
    BaseFragment<SearchTrackViewModel, FragmentSearchBinding>(SearchTrackViewModel::class) {

    override val layoutRes: Int
        get() = R.layout.fragment_search
    override val bindingVariable: Int
        get() = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
