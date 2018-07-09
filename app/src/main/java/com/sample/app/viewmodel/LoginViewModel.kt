package com.sample.app.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.sample.app.common.KeyConstants
import com.sample.app.data.remote.response.ApiResponse
import com.sample.app.data.remote.response.ResponseStatus
import com.sample.app.domain.model.User
import com.sample.app.repository.BankRepository
import com.sample.app.schedulers.BaseScheduler
import com.google.gson.JsonObject
import javax.inject.Inject

/**
 * This class represents the login view model
 * @param scheduler : The scheduler for running the background jobs
 * @param bankRepository: The bank repository for performing the
 */
class LoginViewModel @Inject constructor(
        private val scheduler: BaseScheduler,
        private val bankRepository: BankRepository) : BaseViewModel<User>() {

    var userName: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> = MutableLiveData()

    init {
        // Nothing to do here
    }

    fun doLogin() {
        bankRepository.login()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doOnSubscribe { loadingStatus.setValue(true) }
                .doAfterTerminate { loadingStatus.setValue(false) }
                .subscribe({ result ->
                    response.setValue(ApiResponse(ResponseStatus.SUCCESS, result.data, null))
                }, { throwable ->
                    response.setValue(ApiResponse(ResponseStatus.ERROR, null, throwable))
                })
    }


    fun constructLoginParams(): JsonObject {
        val jsonHeader = JsonObject()
        jsonHeader.addProperty(KeyConstants.KEY_PARAM_DEV_ID, "")
        jsonHeader.addProperty(KeyConstants.KEY_USERID, "")
        jsonHeader.addProperty(KeyConstants.KEY_PW, "")
        jsonHeader.addProperty(KeyConstants.KEY_PARAM_DEV_TYPE, "")
        return jsonHeader
    }


}