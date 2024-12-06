package com.mohaberabi.kmp.foodiks.core.domain.source.remote

import com.mohaberabi.kmp.foodiks.core.domain.model.ProductModel

interface ProductsRemoteDataSource {
    suspend fun getAllProducts(): List<ProductModel>
}