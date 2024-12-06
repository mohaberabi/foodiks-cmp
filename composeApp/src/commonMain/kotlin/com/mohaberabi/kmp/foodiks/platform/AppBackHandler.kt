package com.mohaberabi.kmp.foodiks.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
expect fun AppBackHandler(enabled: Boolean = true, onBackPressed: () -> Unit = {})