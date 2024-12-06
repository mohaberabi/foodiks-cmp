package com.mohaberabi.kmp.foodiks.core.data.di

import com.mohaberabi.kmp.foodiks.core.domain.usecase.cart.AddToCartUseCase
import   com.mohaberabi.kmp.foodiks.core.domain.usecase.cart.ClearCartUseCase
import   com.mohaberabi.kmp.foodiks.core.domain.usecase.cart.GetCartUseCase
import   com.mohaberabi.kmp.foodiks.core.domain.usecase.categories.GetAllCategoriesUseCase
import   com.mohaberabi.kmp.foodiks.core.domain.usecase.categories.RefreshCategoriesUseCase
import   com.mohaberabi.kmp.foodiks.core.domain.usecase.connectivity.CheckConnectivityUseCase
import   com.mohaberabi.kmp.foodiks.core.domain.usecase.products.GetAllProductsUseCase
import   com.mohaberabi.kmp.foodiks.core.domain.usecase.products.RefreshProductsUseCase
import   com.mohaberabi.kmp.foodiks.core.domain.usecase.products.SearchProductsUseCase


import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val coreUseCaseModule = module {

    singleOf(::SearchProductsUseCase)
    singleOf(::GetAllCategoriesUseCase)
    singleOf(::RefreshCategoriesUseCase)
    singleOf(::GetAllProductsUseCase)
    singleOf(::RefreshProductsUseCase)
    singleOf(::AddToCartUseCase)
    singleOf(::ClearCartUseCase)
    singleOf(::GetCartUseCase)
    singleOf(::CheckConnectivityUseCase)

}