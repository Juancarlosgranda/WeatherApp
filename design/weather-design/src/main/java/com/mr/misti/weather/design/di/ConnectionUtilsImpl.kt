package com.mr.misti.weather.design.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import com.mr.misti.core.utils.ConnectionUtils
import java.lang.Exception
import javax.inject.Inject

class ConnectionUtilsImpl @Inject constructor(
    private val applicationContext: Context
) : ConnectionUtils {

    @Suppress("DEPRECATION")
    override fun isNetworkAvailable(): Boolean {
        try {
            val connectivityManager =
                applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val nw = connectivityManager.activeNetwork ?: return false
                val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
                return when {
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    //for other device how are able to connect with Ethernet
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } else {
                val nwInfo = connectivityManager.activeNetworkInfo ?: return false
                return nwInfo.isConnected
            }
        } catch (e: Exception) {
            Log.e("NetworkUtils", "Exception happened: ${e.message}")
            return false
        }
    }
}