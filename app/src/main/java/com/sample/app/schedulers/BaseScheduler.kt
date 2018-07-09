package com.sample.app.schedulers

import android.support.annotation.NonNull
import io.reactivex.Scheduler


/**
 * Base Scheduler implementation
 * Author: Lajesh D
 * Company: Farabi Technologies
 * Email: Lajesh@farabi.ae
 * Created: 7/1/2018
 * Modified: 7/1/2018
 */
interface BaseScheduler {

    @NonNull
    fun io(): Scheduler

    @NonNull
    fun ui(): Scheduler

}