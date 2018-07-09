package com.sample.app.di.components

import android.app.Application
import com.sample.app.AppApplication
import com.sample.app.di.modules.AppModule
import com.sample.app.di.modules.NetworkModule
import com.sample.app.di.modules.PreLoginActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


/**
 * Application Component
 * Author: Lajesh D
 * Company: Farabi Technologies
 * Email: Lajesh@farabi.ae
 * Created: 7/1/2018
 * Modified: 7/1/2018
 */

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            AppModule::class,
            NetworkModule::class,
            PreLoginActivityModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(appApp: AppApplication)
}