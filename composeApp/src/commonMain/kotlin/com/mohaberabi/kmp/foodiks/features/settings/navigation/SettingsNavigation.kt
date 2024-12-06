package com.mohaberabi.kmp.foodiks.features.settings.navigation
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mohaberabi.kmp.foodiks.features.settings.screen.SettingsScreen
import kotlinx.serialization.Serializable


@Serializable
data object SettingsRoute


fun NavGraphBuilder.settingsScreen() = composable<SettingsRoute> { SettingsScreen() }