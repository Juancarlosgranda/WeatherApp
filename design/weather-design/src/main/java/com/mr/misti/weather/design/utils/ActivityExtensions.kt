package com.mr.misti.weather.design.utils

import android.app.Activity
import android.content.Context
import android.widget.Toast

fun Context.showToast(message: Any?) {
    val textToShow = when (message) {
        is Int -> getString(message)
        is String -> message
        else -> {
            ""
        }
    }
    Toast.makeText(this, textToShow, Toast.LENGTH_LONG).show()
}