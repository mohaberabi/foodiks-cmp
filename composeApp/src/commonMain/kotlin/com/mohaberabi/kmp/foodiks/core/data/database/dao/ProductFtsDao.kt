package com.mohaberabi.kmp.foodiks.core.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.mohaberabi.kmp.foodiks.core.data.database.entity.ProductFtsEntity
import com.mohaberabi.kmp.foodiks.core.domain.source.local.ProductId
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductFtsDao {
    @Upsert
    suspend fun insertFtsProducts(items: List<ProductFtsEntity>)

    @Query("SELECT id FROM productFts WHERE productFts MATCH :query")
    fun searchProducts(query: String): Flow<List<ProductId>>
}