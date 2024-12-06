package com.mohaberabi.kmp.foodiks.core.domain.usecase.cart

import com.mohaberabi.kmp.foodiks.core.domain.model.CartItemModel
import com.mohaberabi.kmp.foodiks.core.domain.repository.CartRepository

class AddToCartUseCase(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(item: CartItemModel) = cartRepository.addToCart(item)

}