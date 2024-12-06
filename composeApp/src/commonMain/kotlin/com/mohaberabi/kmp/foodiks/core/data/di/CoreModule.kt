package com.mohaberabi.kmp.foodiks.core.data.di


import androidx.lifecycle.SavedStateHandle
import com.mohaberabi.kmp.foodiks.core.common.util.DefaultDispatchersProvider
import com.mohaberabi.kmp.foodiks.core.common.util.DispatchersProvider
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val coreModule = module {
    factory { SavedStateHandle() }
    singleOf(::DefaultDispatchersProvider) { bind<DispatchersProvider>() }


}

