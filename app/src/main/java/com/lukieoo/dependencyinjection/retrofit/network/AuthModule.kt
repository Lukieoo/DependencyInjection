package com.lukieoo.dependencyinjection.retrofit.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {
    companion object{
        @JvmStatic
        @Provides
        fun provideSessionApi(retrofit: Retrofit):AuthApi{
            return retrofit.create<AuthApi>(
                AuthApi::class.java)

        }

    }
}