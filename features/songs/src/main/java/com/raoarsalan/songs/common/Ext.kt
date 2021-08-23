package com.raoarsalan.songs.common

import android.graphics.Color


fun getColorWithAlpha(color: Int, ratio: Float): Int {
    return Color.argb(
        Math.round(Color.alpha(color) * ratio), Color.red(color), Color.green(color),
        Color.blue(color)
    )
}
