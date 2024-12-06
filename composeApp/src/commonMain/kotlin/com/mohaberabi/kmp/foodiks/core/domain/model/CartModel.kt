package com.mohaberabi.kmp.foodiks.core.domain.model

import com.mohaberabi.kmp.foodiks.platform.clockFormat
import com.mohaberabi.kmp.foodiks.platform.toCurrencyFormat


data class CartModel(
    private val items: Map<String, CartItemModel> = mapOf()
) : Map<String, CartItemModel> by items {
    private val cartTotal: Double = values.toList().sumOf { it.totalPrice }
    val cartTotalFormatted: String get() = cartTotal.toCurrencyFormat()
    val cartSizeFormatted: String get() = size.clockFormat()
}


