package com.mohaberabi.kmp.foodiks.core.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4


@Fts4(contentEntity = ProductEntity::class)
@Entity("productFts")
data class ProductFtsEntity(

    @ColumnInfo(name = "id")
    val productId: String,
    @ColumnInfo(name = "name")
    val productName: String,
    @ColumnInfo(name = "categoryName")
    val productCategoryName: String,
)
