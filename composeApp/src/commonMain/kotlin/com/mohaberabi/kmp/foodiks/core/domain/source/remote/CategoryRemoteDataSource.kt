package com.mohaberabi.kmp.foodiks.core.domain.source.remote

import com.mohaberabi.kmp.foodiks.core.domain.model.CategoryModel


interface CategoryRemoteDataSource {
    suspend fun getAllCategories(): List<CategoryModel>
}