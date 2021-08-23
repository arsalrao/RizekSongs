package com.raoarsalan.rizeksongs

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.raoarsalan.core.ui.base.BaseActivity
import com.raoarsalan.rizeksongs.databinding.ActivityMainBinding
import com.raoarsalan.songs.BR


class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(MainViewModel::class) {
    override val layoutRes: Int
        get() = R.layout.activity_main
    override val bindingVariable: Int
        get() = BR.viewModel

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        NavigationUI.setupWithNavController(
            Toolbar(this),
            Navigation.findNavController(this, R.id.fragmentContainer)
        )

    }
}