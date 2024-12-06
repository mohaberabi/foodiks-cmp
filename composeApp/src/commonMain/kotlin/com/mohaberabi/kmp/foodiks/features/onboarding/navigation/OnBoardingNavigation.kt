package com.mohaberabi.kmp.foodiks.features.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mohaberabi.kmp.foodiks.features.onboarding.screen.OnBoardingScreen
import com.mohaberabi.kmp.foodiks.platform.AppBackHandler
import kotlinx.serialization.Serializable


@Serializable
data object OnBoardingRoute


fun NavGraphBuilder.onBoardingScreen(
    onGetStarted: () -> Unit
) = composable<OnBoardingRoute> {
    AppBackHandler {

    }
    OnBoardingScreen(
        onGetStarted = onGetStarted
    )
}