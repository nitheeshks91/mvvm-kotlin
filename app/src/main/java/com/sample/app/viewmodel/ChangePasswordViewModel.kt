package com.sample.app.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.sample.app.domain.model.User
import com.sample.app.repository.BankRepository
import com.sample.app.schedulers.BaseScheduler
import javax.inject.Inject

/**
 * Viewmodel class for Change password fragment
 * Author: Nitheesh ks
 * Company: Farabi Technologies
 * Email: nitheesh@farabi.ae
 * Created: 7/8/2018
 * Modified: 7/8/2018
 */
class ChangePasswordViewModel @Inject constructor(
        private val scheduler: BaseScheduler,
        private val bankRepository: BankRepository) : BaseViewModel<User>() {

    var newPasspord: MutableLiveData<String> = MutableLiveData()
    var confirmPassword: MutableLiveData<String> = MutableLiveData()
    var backPress: MutableLiveData<Boolean> = MutableLiveData()


    fun doChangePassword() {

    }

    fun onBackClick() {
        backPress.value = true
    }

}