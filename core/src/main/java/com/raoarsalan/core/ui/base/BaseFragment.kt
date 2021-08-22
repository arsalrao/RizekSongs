package com.raoarsalan.core.ui.base

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.raoarsalan.core.R
import com.raoarsalan.core.viewmodel.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

abstract class BaseFragment<V : ViewModel, D : ViewDataBinding>(clazz: KClass<V>) :
    Fragment() {

    val viewModel: V by viewModel(clazz)
    protected lateinit var dataBinding: D

    @get:LayoutRes
    protected abstract val layoutRes: Int

    abstract val bindingVariable: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        return dataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.setVariable(bindingVariable, viewModel)
        dataBinding.executePendingBindings()

        observe()
    }

    private fun observe() {

        (viewModel as BaseViewModel).getError().observe(
            viewLifecycleOwner,
            Observer {
                showErrorDialog(it?.errorMessage as String)
            }
        )
    }

    private fun showErrorDialog(message: String?) {
        val alertDialog = AlertDialog.Builder(activity)
            .setTitle(requireActivity().getString(R.string.title_error))
            .setMessage(message)
            .setPositiveButton(requireActivity().getString(R.string.action_ok), null)
            .create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

}
