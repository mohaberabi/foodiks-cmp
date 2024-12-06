package com.mohaberabi.kmp.foodiks.core.domain.repository

import com.mohaberabi.kmp.foodiks.core.common.Refreshable
import com.mohaberabi.kmp.foodiks.core.domain.model.CategoryModel
import kotlinx.coroutines.flow.Flow

interface CategoryRepository : Refreshable {
    fun getAllCategories(): Flow<List<CategoryModel>>
}