package com.mohaberabi.kmp.foodiks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mohaberabi.kmp.foodiks.core.presentation.design_system.theme.FoodiksTheme
import com.mohaberabi.kmp.foodiks.foodiks.FoodiksComposedAppRoot
import com.mohaberabi.kmp.foodiks.foodiks.rememberFoodiksAppState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            val state = rememberFoodiksAppState()
            FoodiksTheme {
                FoodiksComposedAppRoot(
                    foodiksState = state,
                )
            }

        }
    }
}

@Preview
@Composable
fun PreviewComposbales() {

}