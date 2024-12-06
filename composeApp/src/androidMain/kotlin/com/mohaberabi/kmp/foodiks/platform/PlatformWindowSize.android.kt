package com.mohaberabi.kmp.foodiks.platform

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
actual fun getWindowWidthSize(): WindowWidthSizeClass {
    val context = LocalContext.current
    val activity = context as ComponentActivity
    return calculateWindowSizeClass(activity).widthSizeClass

}