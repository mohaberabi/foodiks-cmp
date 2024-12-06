package com.mohaberabi.kmp.foodiks.features.tables.presentation.viewmodel

import com.mohaberabi.kmp.foodiks.core.presentation.util.UiText

sealed interface TablesEvents {
    data object OrderDone : TablesEvents
    data class Error(val error: UiText) : TablesEvents

}