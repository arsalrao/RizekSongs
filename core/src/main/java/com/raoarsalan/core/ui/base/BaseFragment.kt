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
import androidx.navigation.fragment.findNavController
import com.raoarsalan.core.R
import com.raoarsalan.core.utils.NavigationCommand
import com.raoarsalan.core.viewmodel.BaseViewModel
import com.raoarsalan.core.viewmodel.ShareViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

abstract class BaseFragment<V : ViewModel, D : ViewDataBinding>(clazz: KClass<V>) :
    Fragment() {

    val viewModel: V by viewModel(clazz)
    protected lateinit var dataBinding: D

    @get:LayoutRes
    protected abstract val layoutRes: Int

    abstract val bindingVariable: Int

    private val sharedModel by sharedViewModel(ShareViewModel::class)
    open lateinit var sharedViewModel: ShareViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (viewModel as BaseViewModel).sharedViewModel = sharedModel
        sharedViewModel = sharedModel
    }


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

        (viewModel as BaseViewModel).navigationCommands.observe(
            viewLifecycleOwner,
            Observer {
                when (it) {
                    is NavigationCommand.To -> findNavController().navigate(it.directions)
                    is NavigationCommand.Back -> findNavController().popBackStack()
                }
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
