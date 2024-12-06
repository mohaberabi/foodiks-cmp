package com.mohaberabi.kmp.foodiks.features.layout.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mohaberabi.kmp.foodiks.core.presentation.compose.ActiveUserAppBar
import com.mohaberabi.kmp.foodiks.core.presentation.compose.AppScaffold
import com.mohaberabi.kmp.foodiks.core.presentation.compose.MainBottomBar
import com.mohaberabi.kmp.foodiks.features.layout.navigation.BottomNavItems
import com.mohaberabi.kmp.foodiks.features.layout.viewmodel.LayoutViewModel
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun LayoutScreenRoot(

    onNavigateBottom: (BottomNavItems) -> Unit,
    isBottomItemSelected: (BottomNavItems) -> Boolean,
    viewmodel: LayoutViewModel = koinViewModel(),
    content: @Composable () -> Unit,
) {
    val connected by viewmodel.isConnected.collectAsStateWithLifecycle()
    LayoutScreen(
        onNavigateBottom = onNavigateBottom,
        isBottomItemSelected = isBottomItemSelected,
        content = content,
        isConnected = connected
    )
}

@Composable
fun LayoutScreen(
    onNavigateBottom: (BottomNavItems) -> Unit,
    isBottomItemSelected: (BottomNavItems) -> Boolean,
    content: @Composable () -> Unit,
    isConnected: Boolean,
) {

    AppScaffold(
        topAppBar = {
            ActiveUserAppBar(
                isConnected = isConnected,
            )
        },
        bottomAppBar = {
            MainBottomBar(
                onClick = onNavigateBottom,
                selected = isBottomItemSelected
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            content()
        }

    }
}