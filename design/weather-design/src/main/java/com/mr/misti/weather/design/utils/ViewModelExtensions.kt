package com.mr.misti.weather.design.utils

import androidx.lifecycle.ViewModel
import com.mr.misti.core.Failure
import com.mr.misti.weather.design.R

fun ViewModel.handleUseCaseFailure(failure: Failure): Any?{
    return when(failure) {
        is Failure.UnauthorizedOrForbidden -> failure.message
        is Failure.None -> R.string.error_failure_none
        is Failure.NetworkConnectionLostSuddenly -> R.string.error_failure_network_connection_lost_suddenly
        is Failure.NoNetworkDetected -> R.string.error_failure_no_network_detected
        is Failure.SSLError -> R.string.error_failure_ssl
        is Failure.TimeOut -> R.string.error_failure_time_out
        is Failure.ServerBodyError -> failure.message
        is Failure.DataToDomainMapperFailure -> R.string.error_general
        is Failure.ServiceUncaughtFailure -> R.string.error_failure_uncaught
        else -> R.string.error_unknown
    }
}