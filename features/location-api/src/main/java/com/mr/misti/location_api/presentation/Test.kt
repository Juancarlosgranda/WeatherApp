package com.mr.misti.location_api.presentation

data class Test(
    val name: String,
    val value: String
)

fun Test.toJustName() = this.name