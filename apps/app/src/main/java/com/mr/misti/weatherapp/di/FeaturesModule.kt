package com.mr.misti.weatherapp.di

import com.mr.misti.location.config_di.FeatureLocationModule
import dagger.Module

@Module(includes = [
    FeatureLocationModule::class,
])
abstract class FeaturesModule