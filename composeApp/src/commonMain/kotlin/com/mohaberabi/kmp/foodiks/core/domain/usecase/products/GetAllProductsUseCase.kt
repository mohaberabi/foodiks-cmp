package com.mohaberabi.kmp.foodiks.core.domain.usecase.products

import com.mohaberabi.kmp.foodiks.core.domain.model.ProductModel
import com.mohaberabi.kmp.foodiks.core.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetAllProductsUseCase(
    private val productRepository: ProductRepository
) {
    operator fun invoke(): Flow<List<ProductModel>> = productRepository.getAllProducts()
}