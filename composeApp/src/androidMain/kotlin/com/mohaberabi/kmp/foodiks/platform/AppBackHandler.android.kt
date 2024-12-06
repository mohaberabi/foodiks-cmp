package com.mohaberabi.kmp.foodiks.platform

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable
actual fun AppBackHandler(enabled: Boolean, onBackPressed: () -> Unit) {

    BackHandler(onBack = onBackPressed, enabled = enabled)
}