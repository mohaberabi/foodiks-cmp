package com.mohaberabi.kmp.foodiks.core.presentation.util

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource


sealed interface UiText {


    data object Empty : UiText
    data class Dynamic(val value: String) : UiText

    class StringRes(val id: StringResource, vararg val formatArgs: Any?) : UiText


    @Composable
    fun fold(): String {
        return when (this) {
            is Dynamic -> this.value
            Empty -> ""
            is StringRes -> stringResource(this.id, this.formatArgs)
        }
    }

    suspend fun getValue(): String {
        return when (this) {
            is Dynamic -> this.value
            Empty -> ""
            is StringRes -> getString(this.id, this.formatArgs)
        }

    }

}