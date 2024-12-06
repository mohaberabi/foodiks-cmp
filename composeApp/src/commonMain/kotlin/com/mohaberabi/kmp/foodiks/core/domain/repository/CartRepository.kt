package com.mohaberabi.kmp.foodiks.core.domain.repository

import com.mohaberabi.kmp.foodiks.core.domain.model.AppResult
import com.mohaberabi.kmp.foodiks.core.domain.model.CartItemModel
import com.mohaberabi.kmp.foodiks.core.domain.model.CartModel
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getCartItems(): Flow<CartModel>
    suspend fun addToCart(item: CartItemModel): AppResult<Unit>
    suspend fun clearCart(): AppResult<Unit>
}