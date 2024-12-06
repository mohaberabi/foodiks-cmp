package com.mohaberabi.kmp.foodiks.features.tables.presentation.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.mohaberabi.kmp.foodiks.core.domain.model.ProductModel
import com.mohaberabi.kmp.foodiks.core.presentation.design_system.theme.Spacing
import com.mohaberabi.kmp.foodiks.platform.getWindowWidthSize

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ResponsiveProductGrid(
    products: List<ProductModel>,
    modifier: Modifier = Modifier,
    scrollState: LazyGridState = rememberLazyGridState(),
    onProductClick: (ProductModel) -> Unit,
    cartQty: (ProductModel) -> Int,
) {


    val windowWidthSize = getWindowWidthSize()
    val columns = when (windowWidthSize) {
        WindowWidthSizeClass.Compact -> 2
        WindowWidthSizeClass.Medium -> 3
        else -> 4
    }

    LazyVerticalGrid(
        contentPadding = PaddingValues(Spacing.sm),
        state = scrollState,
        columns = GridCells.Fixed(columns),
        modifier = modifier.fillMaxSize(),
    ) {
        items(products) { product ->
            ProductCard(
                onClick = { onProductClick(product) },
                product = product,
                cartQty = cartQty(product)
            )
        }
    }
}