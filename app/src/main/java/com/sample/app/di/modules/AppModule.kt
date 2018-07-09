package com.sample.app.di.modules

import com.sample.app.data.remote.Api
import com.sample.app.repository.BankRepository
import com.sample.app.schedulers.BaseScheduler
import com.sample.app.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 * Application Module which is responsible for providing the app wide instances.
 * Author: Lajesh D
 * Company: Farabi Technologies
 * Email: Lajesh@farabi.ae
 * Created: 7/1/2018
 * Modified: 7/1/2018
 */
@Module(includes = [(ViewModelModule::class)])
class AppModule {

    @Provides
    @Singleton
    fun provideApi(retorfit: Retrofit) : Api {
        return retorfit.create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: Api): BankRepository {
        return BankRepository(api)
    }

    @Provides
    @Singleton
    fun provideScheduler(): BaseScheduler {
        return SchedulerProvider()
    }
}