package com.sample.app.repository

import com.sample.app.data.remote.Api
import com.sample.app.data.remote.response.ApiResponse
import com.sample.app.domain.model.User
import io.reactivex.Observable
import javax.inject.Inject



class BankRepository @Inject constructor(private val api: Api) {

    fun login(): Observable<ApiResponse<User>> {
        return api.login()
    }

}