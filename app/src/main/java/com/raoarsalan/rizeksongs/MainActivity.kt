package com.raoarsalan.rizeksongs

import android.os.Bundle
import com.raoarsalan.core.ui.base.BaseActivity
import com.raoarsalan.rizeksongs.databinding.ActivityMainBinding

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

    }
}