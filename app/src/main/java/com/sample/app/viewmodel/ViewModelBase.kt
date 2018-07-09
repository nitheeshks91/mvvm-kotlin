package com.sample.app.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sample.app.data.remote.response.ApiResponse

open class BaseViewModel<T> : ViewModel() {

    val response: MutableLiveData<ApiResponse<T>> = MutableLiveData()

    val loadingStatus: MutableLiveData<Boolean> = MutableLiveData()

}