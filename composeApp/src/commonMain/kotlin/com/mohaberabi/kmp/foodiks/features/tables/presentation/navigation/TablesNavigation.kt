package com.mohaberabi.kmp.foodiks.features.tables.presentation.navigation
import TablesScreenRoot
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object TablesRoute

fun NavGraphBuilder.tablesScreen(
) = composable<TablesRoute>() {
    TablesScreenRoot()
}

