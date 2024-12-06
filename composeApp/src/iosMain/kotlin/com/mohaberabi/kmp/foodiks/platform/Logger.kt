@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.mohaberabi.kmp.foodiks.platform

import com.mohaberabi.kmp.foodiks.core.domain.model.error.AppError
import platform.Foundation.NSLog


actual object AppLogger {
    actual fun e(tag: String, message: String, throwable: Throwable?) {

        if (throwable != null) {
            NSLog("ERROR: [$tag] $message. Throwable: $throwable CAUSE ${throwable.cause}")
        } else {
            NSLog("ERROR: [$tag] $message")
        }
    }

    actual fun d(tag: String, message: String) {
        NSLog("DEBUG: [$tag] $message")
    }

    actual fun i(tag: String, message: String) {
        NSLog("INFO: [$tag] $message")
    }

    actual fun appError(error: AppError) {
        NSLog("appError ${error}")
    }


}