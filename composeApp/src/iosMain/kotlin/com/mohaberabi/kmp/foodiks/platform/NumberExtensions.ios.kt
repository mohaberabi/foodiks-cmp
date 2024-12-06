package com.mohaberabi.kmp.foodiks.platform

import platform.Foundation.*

actual fun Number.toCurrencyFormat(): String {
    val formatter = NSNumberFormatter().apply {
        numberStyle = NSNumberFormatterDecimalStyle
        minimumFractionDigits = 2u
        maximumFractionDigits = 2u
        locale = NSLocale.currentLocale
    }
    return formatter.stringFromNumber(NSNumber(this.toDouble())) ?: "$this"
}

actual fun Number.clockFormat(): String {
    return NSString.stringWithFormat("%02d", this.toInt())
}