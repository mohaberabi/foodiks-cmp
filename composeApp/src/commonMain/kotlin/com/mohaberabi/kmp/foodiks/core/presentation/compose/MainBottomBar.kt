package com.mohaberabi.kmp.foodiks.core.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import com.mohaberabi.kmp.foodiks.features.layout.navigation.BottomNavItems
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun MainBottomBar(
    modifier: Modifier = Modifier,
    onClick: (BottomNavItems) -> Unit = {},
    selected: (BottomNavItems) -> Boolean
) {


    BottomAppBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
    ) {

        BottomNavItems.entries.forEach { item ->

            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = Color.Transparent,
                    unselectedIconColor = Color.Gray
                ),
                label = {
                    Text(text = stringResource(item.label))
                },
                selected = selected(item),
                onClick = { onClick(item) },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp)
                    )

                }
            )
        }
    }
}


