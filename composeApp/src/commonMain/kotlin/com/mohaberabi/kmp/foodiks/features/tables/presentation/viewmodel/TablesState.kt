package com.mohaberabi.kmp.foodiks.features.tables.presentation.viewmodel

import androidx.compose.runtime.Stable
import com.mohaberabi.kmp.foodiks.core.domain.model.CategoryModel
import com.mohaberabi.kmp.foodiks.core.domain.model.ProductModel


enum class TablesStatus {
    Initial,
    Loading,
    Populated,
    Error;

    val isError: Boolean get() = this == Error

    val isLoading: Boolean get() = this == Loading
}

@Stable
data class TablesState(
    val products: List<ProductModel> = listOf(),
    val categories: List<CategoryModel> = listOf(),
    val status: TablesStatus = TablesStatus.Initial
)
