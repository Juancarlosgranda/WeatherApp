package com.mr.misti.location.config_di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mr.misti.location.data.repository.LocationRepositoryImpl
import com.mr.misti.location.domain.repository.LocationRepository
import com.mr.misti.location.presentation.ui.search.SearchViewModel
import com.mr.misti.weather.design.di.ViewModelFactory
import com.mr.misti.weather.design.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FeatureLocationModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    abstract fun provideArticleRepository(locationRepository: LocationRepositoryImpl): LocationRepository

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(
        searchViewModel: SearchViewModel
    ): ViewModel
}