package com.mohaberabi.kmp.foodiks.core.common.util.extension

import com.mohaberabi.kmp.foodiks.core.domain.model.error.DataError
import com.mohaberabi.kmp.foodiks.core.presentation.util.UiText
import foodiks.composeapp.generated.resources.Res
import foodiks.composeapp.generated.resources.*


fun DataError.asUiText() = when (this) {
    DataError.CommonError.RetryAttemptExceeded -> Res.string.retry_exced
    DataError.LocalError.DISK_FULL -> Res.string.disk_full
    DataError.LocalError.IO_FAILURE -> Res.string.io_fail
    DataError.LocalError.CONSTRAINT_FAILURE -> Res.string.constraint_failed
    DataError.LocalError.DB_CORRUPTION -> Res.string.db_curropted
    DataError.LocalError.TRANSACTION_FAILED -> Res.string.txn_failed
    DataError.RemoteError.REQUEST_TIMEOUT -> Res.string.request_timeout
    DataError.RemoteError.TOO_MANY_REQUESTS -> Res.string.many_requests
    DataError.RemoteError.NO_INTERNET -> Res.string.no_internet
    DataError.RemoteError.SERVER -> Res.string.server_error
    DataError.RemoteError.SERIALIZATION -> Res.string.server_error
    else -> Res.string.unknown_error
}.let {
    UiText.StringRes(it)
}