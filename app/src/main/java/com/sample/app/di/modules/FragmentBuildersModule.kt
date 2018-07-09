package com.sample.app.di.modules

import com.sample.app.view.dialog.ConfirmationDialogFragment
import com.sample.app.view.fragment.ChangePasswordFragment
import com.sample.app.view.fragment.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * The module which provides the android injection service to fragments.
 * Author: Lajesh D
 * Company: Farabi Technologies
 * Email: Lajesh@farabi.ae
 * Created: 7/1/2018
 * Modified: 7/1/2018
 */
@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeChangePasswordFragment(): ChangePasswordFragment

    @ContributesAndroidInjector
    abstract fun contributeConfirmationDialogFragment(): ConfirmationDialogFragment

}