package com.mr.misti.weather.design.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun String.convertDateFormat(inputDateFormat: String, outputDateFormat: String): String {
    val inputDate = SimpleDateFormat(inputDateFormat)
    val outputDate = SimpleDateFormat(outputDateFormat)
    return try {
        val date = inputDate.parse(this)
        date?.let { outputDate.format(date).toString() }.orEmpty()
    }catch (e: ParseException){
        this
    }
}

fun String.toDate(inputDate: String): Date {
    return SimpleDateFormat(inputDate).parse(this)
}