package com.raoarsalan.core.viewmodel

import androidx.lifecycle.ViewModel
import com.raoarsalan.core.common.SingleLiveEvent
import com.raoarsalan.domain.entity.response.ErrorEntity

abstract class BaseViewModel : ViewModel() {

    /**
     * Live data to handle error
     */
    private val errorEvent = SingleLiveEvent<ErrorEntity.Error?>()

    /**
     * Live data to handle loading
     */
    val loadingEvent = SingleLiveEvent<Boolean>()

    fun setError(error: ErrorEntity.Error?) {
        errorEvent.value = error
    }

    fun getError(): SingleLiveEvent<ErrorEntity.Error?> {
        return errorEvent
    }

    fun showLoading(show: Boolean) {
        loadingEvent.value = show
    }
}