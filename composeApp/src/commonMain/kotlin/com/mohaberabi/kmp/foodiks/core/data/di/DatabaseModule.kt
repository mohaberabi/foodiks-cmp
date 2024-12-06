package com.mohaberabi.kmp.foodiks.core.data.di

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.mohaberabi.kmp.foodiks.core.data.database.AppDatabase
import com.mohaberabi.kmp.foodiks.core.data.database.dao.CartDao
import com.mohaberabi.kmp.foodiks.core.data.database.dao.CategoryDao
import com.mohaberabi.kmp.foodiks.core.data.database.dao.ProductFtsDao
import com.mohaberabi.kmp.foodiks.core.data.database.dao.ProductsDao
import org.koin.dsl.module


val databaseModule = module {

    single<AppDatabase> {
        val builder: RoomDatabase.Builder<AppDatabase> = get()
        builder
            .fallbackToDestructiveMigrationOnDowngrade(dropAllTables = true)
            .fallbackToDestructiveMigration(dropAllTables = true)
            .setDriver(BundledSQLiteDriver())
            .build()
    }

    single<ProductsDao> {
        get<AppDatabase>().productDao()
    }
    single<ProductFtsDao> {
        get<AppDatabase>().productFtsDao()
    }
    single<CategoryDao> {
        get<AppDatabase>().categoryDao()
    }
    single<CartDao> {
        get<AppDatabase>().cartDao()
    }
}