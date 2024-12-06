package com.mohaberabi.kmp.foodiks.platform

import java.util.Locale

actual fun Number.toCurrencyFormat(
): String = String.format(
    Locale.getDefault(),
    "%.2f", this
)

actual fun Number.clockFormat(
): String = String.format(
    Locale.getDefault(),
    "%02d", this
)