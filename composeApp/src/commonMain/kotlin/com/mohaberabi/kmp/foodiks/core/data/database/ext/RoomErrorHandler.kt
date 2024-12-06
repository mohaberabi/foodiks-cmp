package com.mohaberabi.kmp.foodiks.core.data.database.ext

import com.mohaberabi.kmp.foodiks.core.domain.model.error.AppErrorModel
import com.mohaberabi.kmp.foodiks.core.domain.model.error.AppException
import com.mohaberabi.kmp.foodiks.core.domain.model.error.DataError
import kotlinx.coroutines.ensureActive
import kotlinx.io.IOException
import kotlin.coroutines.coroutineContext


suspend inline fun <T> executeDatabaseOperation(operation: () -> T): T {
    return try {
        operation()
    } catch (e: IOException) {
        throw AppException(
            AppErrorModel(
                error = DataError.LocalError.IO_FAILURE,
                message = "IO failure during database operation",
                cause = e
            )
        )
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        e.printStackTrace()
        throw AppException(
            AppErrorModel(
                error = DataError.LocalError.UNKNOWN,
                message = "An unknown database error occurred",
                cause = e
            )
        )
    }
}