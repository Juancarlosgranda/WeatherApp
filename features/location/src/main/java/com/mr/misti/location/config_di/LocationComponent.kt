package com.mr.misti.location.config_di

import com.mr.misti.weather.design.di.ViewModelFactory
import dagger.Subcomponent

@Subcomponent
interface LocationComponent {
    fun inject(viewModelFactory: ViewModelFactory)
}

object LocationComponentProvider {
    lateinit var locationComponent: LocationComponent
}
