package com.mohaberabi.kmp.foodiks.core.data.database.source

import com.mohaberabi.kmp.foodiks.core.common.util.DispatchersProvider
import com.mohaberabi.kmp.foodiks.core.data.database.dao.CategoryDao
import com.mohaberabi.kmp.foodiks.core.data.database.ext.executeDatabaseOperation
import com.mohaberabi.kmp.foodiks.core.data.database.mapper.toCategoryEntity
import com.mohaberabi.kmp.foodiks.core.data.database.mapper.toCategoryModel
import com.mohaberabi.kmp.foodiks.core.domain.model.CategoryModel
import com.mohaberabi.kmp.foodiks.core.domain.source.local.CategoryLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class RoomCategoryLocalDataSource(
    private val dispatchers: DispatchersProvider,
    private val categoryDao: CategoryDao,
) : CategoryLocalDataSource {
    override suspend fun insertAllCategories(categories: List<CategoryModel>) {
        withContext(dispatchers.io) {
            executeDatabaseOperation {
                categoryDao.insertAllCategories(categories.map { list -> list.toCategoryEntity })
            }
        }
    }

    override suspend fun isEmpty(): Boolean {
        return withContext(dispatchers.io) {
            executeDatabaseOperation {
                categoryDao.isEmpty()
            }
        }
    }

    override fun getAllCategories(): Flow<List<CategoryModel>> {
        return categoryDao.getAllCategories().map { list ->
            list.map { it.toCategoryModel }
        }.flowOn(dispatchers.io)
    }
}