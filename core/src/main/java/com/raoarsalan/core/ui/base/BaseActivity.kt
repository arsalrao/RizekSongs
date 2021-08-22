package com.raoarsalan.core.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

abstract class BaseActivity<V : ViewModel, D : ViewDataBinding>(clazz: KClass<V>) :
    AppCompatActivity() {

    @get:LayoutRes
    protected abstract val layoutRes: Int

    abstract val bindingVariable: Int
    protected lateinit var dataBinding: D

    val viewModel: V by viewModel(clazz)
    protected abstract fun getViewModel(): Class<V>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeDataBinding()

    }


    private fun initializeDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, layoutRes)
        dataBinding.lifecycleOwner = this

        dataBinding.setVariable(bindingVariable, viewModel)
        dataBinding.executePendingBindings()
    }
}
