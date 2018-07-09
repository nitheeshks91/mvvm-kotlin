package com.sample.app.data.remote

import com.sample.app.data.remote.response.ApiResponse
import com.sample.app.domain.model.User
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * REST API Access points
 * Author: Lajesh D
 * Company: Farabi Technologies
 * Email: Lajesh@farabi.ae
 * Created: 7/1/2018
 * Modified: 7/1/2018
 */
interface Api {

    @GET("posts/1")
    fun login(): Observable<ApiResponse<User>>
}