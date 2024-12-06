package com.mohaberabi.kmp.foodiks.features.tables.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import com.mohaberabi.kmp.foodiks.core.presentation.design_system.theme.Spacing


@Composable
fun CategoryTab(
    modifier: Modifier = Modifier,
    name: String,
    onClick: () -> Unit = {},
    selected: Boolean = true,
) {


    val style = MaterialTheme.typography.bodyLarge


    Column(
        modifier = modifier
            .wrapContentHeight()
            .clickable { onClick() }
            .padding(Spacing.sm),
    ) {
        Text(
            text = name,
            style = style
        )

        if (selected) {
            val measurer = rememberTextMeasurer()
            val width by remember {
                mutableIntStateOf(
                    measurer.measure(
                        text = name,
                        style = style,
                    ).size.width,
                )
            }
            Spacer(modifier = Modifier.height(Spacing.xs))
            Box(
                modifier = Modifier
                    .height(2.dp)
                    .width(with(LocalDensity.current) { width.toDp() })
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(Spacing.sm)
            )

        }

    }

}


