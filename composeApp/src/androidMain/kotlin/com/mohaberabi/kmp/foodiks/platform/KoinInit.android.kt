package com.mohaberabi.kmp.foodiks.platform

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KoinInit(
    private val context: Context,
) {
    actual fun init(
        vararg extraModules: Module,
    ) {
        startKoin {
            modules(
                *extraModules,
            )
            androidContext(context)
            androidLogger()
        }
    }

}