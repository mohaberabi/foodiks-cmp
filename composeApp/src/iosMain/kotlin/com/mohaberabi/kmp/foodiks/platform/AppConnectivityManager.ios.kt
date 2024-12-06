package com.mohaberabi.kmp.foodiks.platform

import com.mohaberabi.kmp.foodiks.core.common.util.DispatchersProvider
import com.plusmobileapps.konnectivity.Konnectivity
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOf


actual class AppConnectivityManager(
    private val konnectivity: Konnectivity
) {
    actual val isConnected: Flow<Boolean>
        get() = konnectivity.isConnectedState

}