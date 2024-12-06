package com.mohaberabi.kmp.foodiks.features.tables.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.mohaberabi.kmp.foodiks.core.domain.model.CartModel
import com.mohaberabi.kmp.foodiks.core.domain.model.CategoryModel
import com.mohaberabi.kmp.foodiks.core.domain.model.ProductModel
import com.mohaberabi.kmp.foodiks.core.presentation.compose.AppPlaceHolder
import com.mohaberabi.kmp.foodiks.core.presentation.compose.CartButton
import foodiks.composeapp.generated.resources.Res
import foodiks.composeapp.generated.resources.no_products
import foodiks.composeapp.generated.resources.no_search_results_found
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TablesPopualtedBox(
    modifier: Modifier = Modifier,
    cartState: CartModel,
    products: List<ProductModel>,
    categories: List<CategoryModel>,
    onProductClick: (ProductModel) -> Unit,
    onConfirmOrder: () -> Unit = {},
    gridScrollState: LazyGridState = rememberLazyGridState(),
    rowScrollState: LazyListState = rememberLazyListState(),
    selectedCategoryIndex: Int,
    onCategoryClicked: (Int) -> Unit,
    searchQuery: String,
    onRefreshProducts: () -> Unit = {},
    isRefreshingData: Boolean = false
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {

        PullToRefreshBox(
            onRefresh = onRefreshProducts,
            isRefreshing = isRefreshingData
        ) {
            Column {
                CategoryLazyRow(
                    categories = categories,
                    scrollState = rowScrollState,
                    selectedCategoryIndex = selectedCategoryIndex,
                    onCategoryClick = onCategoryClicked
                )

                when {
                    products.isEmpty() && searchQuery.isNotEmpty() -> AppPlaceHolder(
                        title = stringResource(
                            Res.string.no_search_results_found
                        )
                    )

                    products.isEmpty() -> AppPlaceHolder(
                        title = stringResource(
                            Res.string.no_products
                        ),
                        onRetry = onRefreshProducts
                    )

                    else -> {
                        ResponsiveProductGrid(
                            modifier = Modifier
                                .padding(bottom = 60.dp)
                                .background(Color.LightGray.copy(alpha = 0.33f)),
                            scrollState = gridScrollState,
                            products = products,
                            cartQty = { cartState[it.id]?.qty ?: 0 },
                            onProductClick = onProductClick
                        )
                    }

                }

            }
        }


        CartButton(
            onClick = onConfirmOrder,
            height = 60.dp,
            enabled = cartState.isNotEmpty(),
            cartTotal = cartState.cartTotalFormatted,
            cartSize = cartState.cartSizeFormatted
        )
    }
}