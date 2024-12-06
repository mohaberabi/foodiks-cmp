package com.mohaberabi.kmp.foodiks.core.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mohaberabi.kmp.foodiks.core.presentation.compose.PrimaryButton
import com.mohaberabi.kmp.foodiks.core.presentation.design_system.theme.Spacing
import foodiks.composeapp.generated.resources.Res
import foodiks.composeapp.generated.resources.empty_data
import foodiks.composeapp.generated.resources.ic_info
import foodiks.composeapp.generated.resources.try_again
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun AppPlaceHolder(
    modifier: Modifier = Modifier,
    title: String = "Nothing Was Found ... Try again Later !",
    onRetry: (() -> Unit)? = null
) {


    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Icon(
            painter = painterResource(Res.drawable.ic_info),
            tint = Color.LightGray,
            contentDescription = stringResource(Res.string.empty_data),
            modifier = Modifier
                .size(85.dp)
        )
        Spacer(modifier = Modifier.height(Spacing.md))
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = Spacing.md),
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            ),
        )

        Text(
            text = stringResource(Res.string.try_again),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.DarkGray,
            ),
        )

        if (onRetry != null) {
            PrimaryButton(
                label = stringResource(Res.string.try_again),
                onClick = { onRetry() }
            )
        }

    }

}

