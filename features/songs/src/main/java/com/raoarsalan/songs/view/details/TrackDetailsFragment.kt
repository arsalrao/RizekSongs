package com.raoarsalan.songs.view.details

import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
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


        Glide.with(this).asBitmap().load(
            viewModel.sharedViewModel.track?.album?.images?.get(0)?.url
        ).into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                createPaletteAsync(resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })

    }


    private fun createPaletteAsync(bitmap: Bitmap) {
        Palette.from(bitmap).generate { palette ->
            // Use generated instance
            val defaultColor = ContextCompat.getColor(requireContext(), R.color.white)
            val color = palette?.getVibrantColor(defaultColor) ?: defaultColor
            dataBinding.playerItem.playFab.backgroundTintList = ColorStateList.valueOf(color)
        }
    }

}