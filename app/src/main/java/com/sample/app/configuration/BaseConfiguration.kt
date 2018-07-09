package com.sample.app.configuration
import android.support.annotation.IntDef

/**
 * This class will keep all the configuartion details for the particular build flavor
 * Author: Lajesh D
 * Company: Farabi Technologies
 * Email: Lajesh@farabi.ae
 * Created: 7/2/2018
 * Modified: 7/2/2018
 */
object BaseConfiguration {

    private const val SIT = 0

    private const val DEV = 1

    @BaseConfiguration.NavigationType
    private val defaultEnvironment = SIT

    val ENABLE_SECURITY_CHECK = false

    private val URL_SIT = "https://jsonplaceholder.typicode.com/" //Put the SIT url here

    private val URL_DEV = "https://jsonplaceholder.typicode.com/" // Put the development url here

    private val URL_PROD = "https://jsonplaceholder.typicode.com/" // Put the production url here

    val baseURL: String
        get() {

            when (defaultEnvironment) {

                SIT -> return URL_SIT

                DEV -> return URL_DEV

                else -> return URL_DEV
            }
        }


    @IntDef(SIT, DEV)
    private annotation class NavigationType
}