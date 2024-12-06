@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.mohaberabi.kmp.foodiks.platform

import com.mohaberabi.kmp.foodiks.core.domain.model.error.AppError


expect object AppLogger {
    fun e(tag: String, message: String, throwable: Throwable? = null)
    fun d(tag: String, message: String)
    fun i(tag: String, message: String)
    fun appError(error: AppError)
}