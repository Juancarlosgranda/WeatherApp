package com.mr.misti.weatherapp.di

import com.mr.misti.weather.design.di.ViewModelComponent
import com.mr.misti.weather.design.di.ViewModelFactoryComponent
import com.mr.misti.weather.design.di.ViewModelKeyModule
import com.mr.misti.weatherapp.WeatherApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,  // provide singleton app context
    NetworkModule::class, // retrofit
    FeaturesModule::class
])
interface AppComponent : AndroidInjector<WeatherApp> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<WeatherApp>
    //fun viewModelComponent(): ViewModelFactoryComponent

}