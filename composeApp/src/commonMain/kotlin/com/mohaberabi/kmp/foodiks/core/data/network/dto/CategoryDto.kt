package com.mohaberabi.kmp.foodiks.core.data.network.dto

import kotlinx.serialization.Serializable


@Serializable
data class CategoryDto(
    val id: String,
    val name: String
)