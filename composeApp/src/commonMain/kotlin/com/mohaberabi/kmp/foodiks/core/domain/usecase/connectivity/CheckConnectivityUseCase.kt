package com.mohaberabi.kmp.foodiks.core.domain.usecase.connectivity

import com.mohaberabi.kmp.foodiks.platform.AppConnectivityManager


class CheckConnectivityUseCase(
    private val connectivityManager: AppConnectivityManager,
) {


    operator fun invoke() = connectivityManager.isConnected
}