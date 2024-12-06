package com.mohaberabi.kmp.foodiks.features.orders.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import foodiks.composeapp.generated.resources.Res
import foodiks.composeapp.generated.resources.orders_screen

import org.jetbrains.compose.resources.stringResource


@Composable
fun OrdersScreen(
    modifier: Modifier = Modifier,
) {


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(Res.string.orders_screen))
    }
}