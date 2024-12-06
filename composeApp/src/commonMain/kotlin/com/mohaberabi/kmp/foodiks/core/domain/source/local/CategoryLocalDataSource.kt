package com.mohaberabi.kmp.foodiks.core.domain.source.local

import com.mohaberabi.kmp.foodiks.core.domain.model.CategoryModel
import kotlinx.coroutines.flow.Flow

interface CategoryLocalDataSource {
    suspend fun insertAllCategories(
        categories: List<CategoryModel>,
    )


    suspend fun isEmpty(): Boolean
    fun getAllCategories(): Flow<List<CategoryModel>>
}