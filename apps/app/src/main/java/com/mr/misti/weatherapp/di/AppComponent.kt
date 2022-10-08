package com.mr.misti.weatherapp.di

import com.mr.misti.weatherapp.WeatherApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class
])
interface AppComponent : AndroidInjector<WeatherApp> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<WeatherApp>

}