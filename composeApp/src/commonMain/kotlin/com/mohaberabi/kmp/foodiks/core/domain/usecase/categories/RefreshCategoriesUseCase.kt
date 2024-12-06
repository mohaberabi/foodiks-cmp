package com.mohaberabi.kmp.foodiks.core.domain.usecase.categories

import com.mohaberabi.kmp.foodiks.core.domain.model.AppResult
import com.mohaberabi.kmp.foodiks.core.domain.repository.CategoryRepository

class RefreshCategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(forceRemote: Boolean): AppResult<Unit> =
        categoryRepository.refresh(forceRemote)
}