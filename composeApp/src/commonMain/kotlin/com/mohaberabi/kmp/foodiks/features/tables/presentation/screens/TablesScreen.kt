import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mohaberabi.kmp.foodiks.core.domain.model.CartModel
import com.mohaberabi.kmp.foodiks.core.domain.model.ProductModel
import com.mohaberabi.kmp.foodiks.core.presentation.compose.AppLoader
import com.mohaberabi.kmp.foodiks.core.presentation.compose.AppPlaceHolder
import com.mohaberabi.kmp.foodiks.core.presentation.compose.EventCollector
import com.mohaberabi.kmp.foodiks.core.presentation.extensions.clearFocusOnTap
import com.mohaberabi.kmp.foodiks.features.tables.presentation.compose.MenuStatusTopBar
import com.mohaberabi.kmp.foodiks.features.tables.presentation.compose.SearchTextField
import com.mohaberabi.kmp.foodiks.features.tables.presentation.compose.TablesPopualtedBox
import com.mohaberabi.kmp.foodiks.features.tables.presentation.viewmodel.TablesEvents
import com.mohaberabi.kmp.foodiks.features.tables.presentation.viewmodel.TablesState
import com.mohaberabi.kmp.foodiks.features.tables.presentation.viewmodel.TablesViewModel
import com.mohaberabi.kmp.foodiks.foodiks.LocalSnackBarController
import foodiks.composeapp.generated.resources.Res
import foodiks.composeapp.generated.resources.order_made
import foodiks.composeapp.generated.resources.something_went_wrong
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun TablesScreenRoot(
    viewmodel: TablesViewModel = koinViewModel()
) {
    val snackBarController = LocalSnackBarController.current
    val tablesState by viewmodel.tablesState.collectAsStateWithLifecycle()
    val cartState by viewmodel.cartState.collectAsStateWithLifecycle()
    val searchQuery by viewmodel.searchQuery.collectAsStateWithLifecycle()
    val selectedCategoryIndex by viewmodel.selectedCategoryIndex.collectAsStateWithLifecycle()
    val isRefreshing by viewmodel.isRefreshing.collectAsStateWithLifecycle()
    // products must carry a mapping of their   corresponding category ids
    // so that we can apply the animated scrolling combined with the products and category
    // so it is cached inside of a remember block as a preprocessing step
    // eit can be even optimized further by storing the category index inside of the product data structure so
    // we can achieve it at constant time without even preprocessing
    val categoryToProductIndexMap by remember(tablesState.products) {
        derivedStateOf {
            tablesState.products
                .mapIndexed { index, product -> product.category.id to index }
                .groupBy({ it.first }, { it.second })
                .mapValues { it.value.first() }
        }
    }
    EventCollector(
        flow = viewmodel.events,
    ) { event ->
        when (event) {
            TablesEvents.OrderDone -> snackBarController.show(getString(Res.string.order_made))
            is TablesEvents.Error -> snackBarController.show(event.error.getValue())

        }
    }
    TablesScreen(
        cartState = cartState,
        tablesState = tablesState,
        onSearch = viewmodel::searchQueryChanged,
        onCategoryClicked = viewmodel::categoryIndexChanged,
        onProductClick = viewmodel::addItemToCart,
        searchQuery = searchQuery,
        onConfirmOrder = viewmodel::confirmOrder,
        selectedCategoryIndex = selectedCategoryIndex,
        onRefresh = viewmodel::refreshData,
        onRetry = viewmodel::retryGettingData,
        categoryToProductIndexMap = categoryToProductIndexMap,
        isRefreshingData = isRefreshing
    )
}


@Composable
fun TablesScreen(
    modifier: Modifier = Modifier,
    cartState: CartModel,
    tablesState: TablesState,
    onSearch: (String) -> Unit = {},
    onCategoryClicked: (Int) -> Unit = {},
    onProductClick: (ProductModel) -> Unit = {},
    onConfirmOrder: () -> Unit = {},
    onRefresh: () -> Unit = {},
    onRetry: () -> Unit = {},
    isRefreshingData: Boolean = false,
    searchQuery: String,
    selectedCategoryIndex: Int,
    categoryToProductIndexMap: Map<String, Int> = mapOf(),
) {
    val rowScrollState = rememberLazyListState()
    val gridScrollState = rememberLazyGridState()
    LaunchedEffect(
        key1 = selectedCategoryIndex
    ) {
        rowScrollState.animateScrollToItem(selectedCategoryIndex)
        if (tablesState.products.isNotEmpty()) {
            val currentCategory = tablesState.categories[selectedCategoryIndex]
            val index = categoryToProductIndexMap[currentCategory.id]
            index?.let {
                gridScrollState.animateScrollToItem(it)
            }
        }

    }



    Column(
        modifier = modifier
            .fillMaxSize()
            .clearFocusOnTap(),
    ) {
        MenuStatusTopBar()
        SearchTextField(
            onTextChanged = onSearch,
            value = searchQuery,
        )
        when {
            tablesState.status.isError -> AppPlaceHolder(
                title = stringResource(Res.string.something_went_wrong),
                onRetry = onRetry
            )

            tablesState.status.isLoading -> AppLoader()
            else -> {
                TablesPopualtedBox(
                    modifier = modifier,
                    onConfirmOrder = onConfirmOrder,
                    gridScrollState = gridScrollState,
                    cartState = cartState,
                    products = tablesState.products,
                    categories = tablesState.categories,
                    selectedCategoryIndex = selectedCategoryIndex,
                    searchQuery = searchQuery,
                    onCategoryClicked = onCategoryClicked,
                    onProductClick = onProductClick,
                    rowScrollState = rowScrollState,
                    isRefreshingData = isRefreshingData,
                    onRefreshProducts = onRefresh,
                )
            }

        }
    }

}


