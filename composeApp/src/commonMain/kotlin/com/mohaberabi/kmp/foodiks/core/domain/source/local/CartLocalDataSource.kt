package com.mohaberabi.kmp.foodiks.core.domain.source.local

import com.mohaberabi.kmp.foodiks.core.domain.model.CartItemModel
import kotlinx.coroutines.flow.Flow


typealias CartItemMap = Map<String, CartItemModel>

interface CartLocalDataSource {
    fun getCartItems(): Flow<CartItemMap>
    suspend fun addToCart(item: CartItemModel)
    suspend fun clearCart()
}