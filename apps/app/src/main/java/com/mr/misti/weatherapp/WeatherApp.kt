package com.mr.misti.weatherapp

import com.mr.misti.weatherapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class WeatherApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

}