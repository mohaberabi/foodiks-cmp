@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.mohaberabi.kmp.foodiks.platform

import android.util.Log
import com.mohaberabi.kmp.foodiks.core.domain.model.error.AppError


actual object AppLogger {

    actual fun e(tag: String, message: String, throwable: Throwable?) {
        if (throwable != null) {
            Log.e(tag, message, throwable)
        } else {
            Log.e(tag, message)
        }
    }

    actual fun d(tag: String, message: String) {
        Log.d(tag, message)
    }

    actual fun i(tag: String, message: String) {
        Log.i(tag, message)
    }

    actual fun appError(error: AppError) {
        Log.e("appError", error.toString())
    }

}