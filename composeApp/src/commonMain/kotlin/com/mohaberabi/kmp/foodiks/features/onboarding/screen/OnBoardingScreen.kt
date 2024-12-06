package com.mohaberabi.kmp.foodiks.features.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.mohaberabi.kmp.foodiks.core.presentation.compose.AppScaffold
import com.mohaberabi.kmp.foodiks.core.presentation.compose.PrimaryButton
import com.mohaberabi.kmp.foodiks.core.presentation.design_system.theme.Spacing
import foodiks.composeapp.generated.resources.Res
import foodiks.composeapp.generated.resources.foodics
import foodiks.composeapp.generated.resources.foodiks_logo
import foodiks.composeapp.generated.resources.get_started
import foodiks.composeapp.generated.resources.logo
import foodiks.composeapp.generated.resources.quote
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    onGetStarted: () -> Unit = {},
) {


    AppScaffold { padding ->
        Column(
            modifier = modifier
                .padding(padding)
                .fillMaxSize()
                .padding(Spacing.lg),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Image(
                painter = painterResource(Res.drawable.logo),
                contentDescription = stringResource(Res.string.foodiks_logo),
            )
            Spacer(modifier = Modifier.height(Spacing.lg))
            Text(
                text = stringResource(Res.string.quote),
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Black
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(Spacing.sm))
            Text(
                text = stringResource(Res.string.foodics),
                style = MaterialTheme.typography.bodyMedium.copy(
                ),
                textAlign = TextAlign.Center
            )
            PrimaryButton(

                onClick = onGetStarted,
                label = stringResource(Res.string.get_started),
            )

        }
    }
}

