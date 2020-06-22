package com.lukieoo.dependencyinjection

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
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
    }

}