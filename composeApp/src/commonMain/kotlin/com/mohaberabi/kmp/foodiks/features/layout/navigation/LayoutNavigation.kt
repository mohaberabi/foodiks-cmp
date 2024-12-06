package com.mohaberabi.kmp.foodiks.features.layout.navigation

import com.mohaberabi.kmp.foodiks.features.layout.screen.LayoutScreenRoot
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mohaberabi.kmp.foodiks.features.tables.presentation.navigation.TablesRoute

import com.mohaberabi.kmp.foodiks.foodiks.navigation.isCurrentRoute
import com.mohaberabi.kmp.foodiks.foodiks.navigation.navigateBottom
import com.mohaberabi.kmp.foodiks.platform.AppBackHandler
import kotlinx.serialization.Serializable


@Serializable
data object LayoutRoute


fun NavGraphBuilder.layoutScreen(
    layoutNavController: NavHostController,
) = composable<LayoutRoute> {
    val currentDestination: NavDestination? = layoutNavController
        .currentBackStackEntryAsState().value?.destination

    AppBackHandler(
        enabled = currentDestination.isCurrentRoute(TablesRoute::class),
    ) {

    }
    LayoutScreenRoot(
        onNavigateBottom = { bottom ->
            layoutNavController.navigateBottom(bottom.route)
        },
        isBottomItemSelected = { bottom ->
            currentDestination?.isCurrentRoute(bottom.route::class) ?: false
        },
    ) {
        BottomRoutesNavHost(
            controller = layoutNavController,
        )
    }
}

fun NavController.navigateToLayout() = navigate(LayoutRoute) {
    popUpTo(0) { inclusive = true }
    launchSingleTop = true
}