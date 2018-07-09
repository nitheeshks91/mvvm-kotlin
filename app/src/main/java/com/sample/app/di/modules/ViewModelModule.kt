package com.sample.app.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.sample.app.configuration.mvvm.ViewModelFactory
import com.sample.app.di.keys.ViewModelKey
import com.sample.app.viewmodel.ChangePasswordViewModel
import com.sample.app.viewmodel.ConfirmationDialogViewModel
import com.sample.app.viewmodel.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * This class will provide the viewmodel instances
 * Author: Lajesh D
 * Company: Farabi Technologies
 * Email: Lajesh@farabi.ae
 * Created: 7/1/2018
 * Modified: 7/1/2018
 */
@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(ChangePasswordViewModel::class)
    fun bindChangePasswordViewModel(changePasswordViewModel: ChangePasswordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ConfirmationDialogViewModel::class)
    fun bindConfirmationDialogViewModel(confirmationDialogViewModel: ConfirmationDialogViewModel): ViewModel


    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}