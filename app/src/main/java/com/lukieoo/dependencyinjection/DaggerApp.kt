package com.lukieoo.dependencyinjection

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class DaggerApp : Application(), HasAndroidInjector {


    @Inject
    lateinit var androidInjector:DispatchingAndroidInjector<Any> //in Java Object

    override fun onCreate() {
        super.onCreate()
        //DaggerComponent
        //Build if you not see this
     //  DaggerAppComponent.create().inject(this)
        DaggerAppComponent.builder().application(this)!!.build().inject(this)
    }

    override fun androidInjector()=androidInjector

}