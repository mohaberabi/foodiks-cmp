package com.mohaberabi.kmp.foodiks.core.data.database.mapper

import com.mohaberabi.kmp.foodiks.core.data.database.entity.CartEntity
import com.mohaberabi.kmp.foodiks.core.domain.model.CartItemModel


val CartItemModel.toCartItemEntity
    get() = CartEntity(
        id = id,
        name = name,
        price = price,
        qty = qty
    )

val CartEntity.toCartItemModel
    get() = CartItemModel(
        id = id,
        name = name,
        price = price,
        qty = qty
    )