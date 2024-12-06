package com.mohaberabi.kmp.foodiks.core.domain.usecase.cart

import com.mohaberabi.kmp.foodiks.core.domain.repository.CartRepository

class ClearCartUseCase(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke() = cartRepository.clearCart()
}