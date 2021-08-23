package com.raoarsalan.songs.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("loadAvatar")
    fun loadImageUrl(view: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Glide.with(view.context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(view)
        }
    }
}