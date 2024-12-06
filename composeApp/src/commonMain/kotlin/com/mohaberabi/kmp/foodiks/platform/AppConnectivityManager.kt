package com.mohaberabi.kmp.foodiks.platform

import kotlinx.coroutines.flow.Flow


expect class AppConnectivityManager {


    val isConnected: Flow<Boolean>
}