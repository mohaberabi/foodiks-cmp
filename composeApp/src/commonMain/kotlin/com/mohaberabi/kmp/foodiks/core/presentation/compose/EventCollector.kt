package com.mohaberabi.kmp.foodiks.core.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow


@Composable
fun <T> EventCollector(
    flow: Flow<T>,
    key1: Any? = null,
    key2: Any? = null,
    onEvent: suspend (T) -> Unit,
) {

    LaunchedEffect(
        key1 = flow,
        key2 = key1,
        key3 = key2
    ) {
        flow.collect(onEvent)

    }
}