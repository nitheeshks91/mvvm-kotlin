package com.sample.app.di.modules

import com.sample.app.PreLoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * The module provides which provides the android injection service to activities
 * Author: Lajesh D
 * Company: Farabi Technologies
 * Email: Lajesh@farabi.ae
 * Created: 7/1/2018
 * Modified: 7/1/2018
 */
@Suppress("unused")
@Module
abstract class PreLoginActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): PreLoginActivity
}