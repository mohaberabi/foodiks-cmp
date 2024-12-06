package com.mohaberabi.kmp.foodiks.features.layout.navigation

import com.mohaberabi.kmp.foodiks.features.menu.navigation.MenuRoute
import com.mohaberabi.kmp.foodiks.features.orders.navigation.OrdersRoute
import com.mohaberabi.kmp.foodiks.features.settings.navigation.SettingsRoute
import com.mohaberabi.kmp.foodiks.features.tables.presentation.navigation.TablesRoute
import foodiks.composeapp.generated.resources.Res
import foodiks.composeapp.generated.resources.ic_book
import foodiks.composeapp.generated.resources.ic_fork
import foodiks.composeapp.generated.resources.ic_menu
import foodiks.composeapp.generated.resources.ic_settings
import foodiks.composeapp.generated.resources.menu
import foodiks.composeapp.generated.resources.orders
import foodiks.composeapp.generated.resources.settings
import foodiks.composeapp.generated.resources.tables
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource


enum class BottomNavItems(
    val label: StringResource,
    val icon: DrawableResource
) {

    Tables(Res.string.tables, Res.drawable.ic_fork),
    Orders(Res.string.orders, Res.drawable.ic_book),
    Menu(Res.string.menu, Res.drawable.ic_menu),
    Settings(Res.string.settings, Res.drawable.ic_settings)
}


val BottomNavItems.route: Any
    get() = when (this) {
        BottomNavItems.Tables -> TablesRoute
        BottomNavItems.Orders -> OrdersRoute
        BottomNavItems.Menu -> MenuRoute
        BottomNavItems.Settings -> SettingsRoute
    }