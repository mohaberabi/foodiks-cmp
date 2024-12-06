package com.mohaberabi.kmp.foodiks.core.domain.source.local

import com.mohaberabi.kmp.foodiks.core.domain.model.ProductFtsModel
import kotlinx.coroutines.flow.Flow

typealias ProductId = String

interface ProductFtsLocalDataSource {
    suspend fun insertProductsFts(
        items: List<ProductFtsModel>,
    )


    fun searchProducts(
        query: String,
    ): Flow<List<ProductId>>
}