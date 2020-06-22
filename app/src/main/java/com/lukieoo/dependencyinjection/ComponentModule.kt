package com.lukieoo.dependencyinjection

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.lukieoo.dependencyinjection.retrofit.adapter.LatestAdapter
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class  ComponentModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity():MainActivity

    //Now we test Dagger

    companion object{
        @Singleton
        @JvmStatic
        @Provides
        fun provideDrawable(application: Application):Drawable?{
            return ContextCompat.getDrawable(application,R.drawable.image823)
        }


        @Singleton
        @Provides
        @JvmStatic
        open fun provideAdapter(): LatestAdapter {
            return LatestAdapter();

        }

        @Singleton
        @JvmStatic
        @Provides
        open fun provideRetrofitInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://api.rawg.io")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }




    }

}