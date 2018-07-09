package com.sample.app.data.remote.response


/**
 * Common class used by API responses
 * @param T : Represents the type of
 * Author: Lajesh D
 * Company: Farabi Technologies
 * Email: Lajesh@farabi.ae
 * Created: 7/1/2018
 * Modified: 7/1/2018
 */
data class ApiResponse<out T> (
        val status: Int,
        val data: T?,
        val error: Throwable?
)