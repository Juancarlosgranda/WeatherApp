package com.mr.misti.weather.design.di

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    val io: CoroutineContext
    val main: CoroutineContext
    val default: CoroutineContext
}
