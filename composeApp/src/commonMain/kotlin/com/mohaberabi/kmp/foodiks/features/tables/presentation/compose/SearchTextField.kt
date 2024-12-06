package com.mohaberabi.kmp.foodiks.features.tables.presentation.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mohaberabi.kmp.foodiks.core.presentation.design_system.theme.SearchIcon
import com.mohaberabi.kmp.foodiks.core.presentation.design_system.theme.Spacing
import foodiks.composeapp.generated.resources.Res
import foodiks.composeapp.generated.resources.search
import foodiks.composeapp.generated.resources.search_for_product_or_category
import org.jetbrains.compose.resources.stringResource


@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    onTextChanged: (String) -> Unit = {},
    value: String = ""
) {


    OutlinedTextField(
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.LightGray,
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
            focusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedIndicatorColor = Color.LightGray,
        ),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(Spacing.sm),
        placeholder = {
            Text(
                text = stringResource(Res.string.search_for_product_or_category),
                textAlign = TextAlign.Center,
                lineHeight = 4.sp,
                style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
            )
        },
        prefix = {
            Icon(imageVector = SearchIcon, contentDescription = stringResource(Res.string.search))
        },
        value = value,
        textStyle = MaterialTheme.typography.bodySmall.copy(
            fontSize = 12.sp,
            lineHeight = 12.sp
        ),
        onValueChange = onTextChanged,
    )
}


