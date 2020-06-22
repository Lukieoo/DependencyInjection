package com.lukieoo.dependencyinjection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AndroidInjectionModule::class,
    ComponentModule::class
    ]
)



interface AppComponent :AndroidInjector<DaggerApp> {

    fun inject(application:Application)
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build():AppComponent
    }
}