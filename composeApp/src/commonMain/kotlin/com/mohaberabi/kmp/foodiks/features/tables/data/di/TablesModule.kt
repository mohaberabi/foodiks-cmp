package com.mohaberabi.kmp.foodiks.features.tables.data.di
import com.mohaberabi.kmp.foodiks.features.tables.presentation.viewmodel.TablesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val tablesModule = module {
    viewModelOf(:: TablesViewModel)
}

