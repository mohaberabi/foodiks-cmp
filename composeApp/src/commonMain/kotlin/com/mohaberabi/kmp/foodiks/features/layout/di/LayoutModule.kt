package com.mohaberabi.kmp.foodiks.features.layout.di

import com.mohaberabi.kmp.foodiks.features.layout.viewmodel.LayoutViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val layoutModule = module {
    viewModelOf(::LayoutViewModel)

}