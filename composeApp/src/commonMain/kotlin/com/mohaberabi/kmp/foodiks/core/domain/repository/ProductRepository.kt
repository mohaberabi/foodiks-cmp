package com.mohaberabi.kmp.foodiks.core.domain.repository

import com.mohaberabi.kmp.foodiks.core.common.Refreshable
import com.mohaberabi.kmp.foodiks.core.domain.model.ProductModel
import kotlinx.coroutines.flow.Flow

interface ProductRepository : Refreshable {
    fun searchProducts(
        query: String
    ): Flow<List<ProductModel>>

    fun getAllProducts(): Flow<List<ProductModel>>
}