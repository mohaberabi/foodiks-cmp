package com.mohaberabi.kmp.foodiks.core.domain.usecase.products

import com.mohaberabi.kmp.foodiks.core.domain.model.AppResult
import com.mohaberabi.kmp.foodiks.core.domain.repository.ProductRepository

class RefreshProductsUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(forceRemote: Boolean): AppResult<Unit> =
        productRepository.refresh(forceRemote)
}