package com.mohaberabi.kmp.foodiks.core.data.repository

import com.mohaberabi.kmp.foodiks.core.domain.model.AppResult
import com.mohaberabi.kmp.foodiks.core.domain.model.CategoryModel
import com.mohaberabi.kmp.foodiks.core.domain.model.handleAppResult
import com.mohaberabi.kmp.foodiks.core.domain.repository.CategoryRepository
import com.mohaberabi.kmp.foodiks.core.domain.source.local.CategoryLocalDataSource
import com.mohaberabi.kmp.foodiks.core.domain.source.remote.CategoryRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest

class OfflineFirstCategoryRepository(
    private val categoryRemoteDataSource: CategoryRemoteDataSource,
    private val categoryLocalDataSource: CategoryLocalDataSource,
) : CategoryRepository {
    override fun getAllCategories(): Flow<List<CategoryModel>> {
        return categoryLocalDataSource.getAllCategories().distinctUntilChanged()
            .flatMapLatest { categories ->
                if (categories.isEmpty()) {
                    fetchAndSaveCategories()
                }
                categoryLocalDataSource.getAllCategories()
            }
    }


    override suspend fun refresh(
        forceRemote: Boolean,
    ): AppResult<Unit> {
        val shouldRefresh = categoryLocalDataSource.isEmpty() || forceRemote
        return if (shouldRefresh) {
            handleAppResult { fetchAndSaveCategories() }
        } else {
            AppResult.Done(Unit)
        }
    }

    private suspend fun fetchAndSaveCategories() {
        val remote = categoryRemoteDataSource.getAllCategories()
        categoryLocalDataSource.insertAllCategories(remote)
    }
}