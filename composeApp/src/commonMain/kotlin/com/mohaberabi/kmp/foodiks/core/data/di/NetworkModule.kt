package com.mohaberabi.kmp.foodiks.core.data.di

import com.mohaberabi.kmp.foodiks.core.data.network.client.KtorCategoriesRemoteDataSource
import com.mohaberabi.kmp.foodiks.core.data.network.client.KtorProductsRemoteDataSource
import com.mohaberabi.kmp.foodiks.core.data.network.factory.HttpClientFactory
import com.mohaberabi.kmp.foodiks.core.domain.source.remote.CategoryRemoteDataSource
import com.mohaberabi.kmp.foodiks.core.domain.source.remote.ProductsRemoteDataSource
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val networkModule = module {
    single<HttpClient> { HttpClientFactory(get()).create() }
    singleOf(::KtorCategoriesRemoteDataSource) { bind<CategoryRemoteDataSource>() }
    singleOf(::KtorProductsRemoteDataSource) { bind<ProductsRemoteDataSource>() }
}