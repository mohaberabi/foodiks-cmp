package com.mohaberabi.kmp.foodiks.features.layout.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mohaberabi.kmp.foodiks.features.menu.navigation.menuScreen
import com.mohaberabi.kmp.foodiks.features.orders.navigation.ordersScreen
import com.mohaberabi.kmp.foodiks.features.settings.navigation.settingsScreen
import com.mohaberabi.kmp.foodiks.features.tables.presentation.navigation.TablesRoute
import com.mohaberabi.kmp.foodiks.features.tables.presentation.navigation.tablesScreen


@Composable
fun BottomRoutesNavHost(
    controller: NavHostController,
) {

    NavHost(
        navController = controller,
        startDestination = TablesRoute
    ) {
        tablesScreen()
        menuScreen()
        settingsScreen()
        ordersScreen()
    }
}


