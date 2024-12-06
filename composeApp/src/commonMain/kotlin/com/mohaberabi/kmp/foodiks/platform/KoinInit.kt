package com.mohaberabi.kmp.foodiks.platform

import com.mohaberabi.kmp.foodiks.core.data.di.coreLocalDataSourceModule
import com.mohaberabi.kmp.foodiks.core.data.di.coreModule
import com.mohaberabi.kmp.foodiks.core.data.di.coreRepositoryModule
import com.mohaberabi.kmp.foodiks.core.data.di.coreUseCaseModule
import com.mohaberabi.kmp.foodiks.core.data.di.databaseModule
import com.mohaberabi.kmp.foodiks.core.data.di.networkModule
import com.mohaberabi.kmp.foodiks.features.layout.di.layoutModule
import com.mohaberabi.kmp.foodiks.features.tables.data.di.tablesModule
import org.koin.core.module.Module

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class KoinInit {
    fun init(
        vararg extraModules: Module = arrayOf(
            platformModule,
            coreModule,
            databaseModule,
            networkModule,
            coreLocalDataSourceModule,
            coreRepositoryModule,
            coreUseCaseModule,
            tablesModule,
            layoutModule,
        )
    )
}

