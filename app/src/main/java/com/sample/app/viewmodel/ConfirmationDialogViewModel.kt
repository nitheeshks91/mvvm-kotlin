package com.sample.app.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.sample.app.repository.BankRepository
import com.sample.app.schedulers.BaseScheduler
import javax.inject.Inject

class ConfirmationDialogViewModel @Inject constructor(
        private val scheduler: BaseScheduler,
        private val bankRepository: BankRepository) : BaseViewModel<Boolean>() {

    var positiveButtonClick: MutableLiveData<Boolean> = MutableLiveData()
    var negativeButtonClick: MutableLiveData<Boolean> = MutableLiveData()

    fun onPositiveButtonClick() {
        positiveButtonClick.value = true
    }

    fun onNegativeButtonClick() {
        negativeButtonClick.value = true
    }

}