package com.mr.misti.weather.design.di

interface ViewModelFactoryComponent {
    fun inject(viewModelFactory: ViewModelFactory)
}

object ViewModelComponent {
    lateinit var viewModelFactory: ViewModelFactoryComponent
}