package com.mohaberabi.kmp.foodiks.core.common

import com.mohaberabi.kmp.foodiks.core.domain.model.AppResult

interface Refreshable {
    suspend fun refresh(
        forceRemote: Boolean,
    ): AppResult<Unit>
}