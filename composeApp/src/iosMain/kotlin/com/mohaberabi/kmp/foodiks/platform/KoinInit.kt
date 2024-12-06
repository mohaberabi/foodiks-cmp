package com.mohaberabi.kmp.foodiks.platform

import org.koin.core.context.startKoin
import org.koin.core.module.Module


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KoinInit {
    actual fun init(
        vararg extraModules: Module,
    ) {
        startKoin {
            modules(
                *extraModules,
            )
        }
    }
}


