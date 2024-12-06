package com.mohaberabi.kmp.foodiks.features.menu.navigation
import com.mohaberabi.kmp.foodiks.features.menu.screen.MenuScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object MenuRoute


fun NavGraphBuilder.menuScreen() = composable<MenuRoute> { MenuScreen() }