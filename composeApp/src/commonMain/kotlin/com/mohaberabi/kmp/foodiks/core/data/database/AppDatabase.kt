package com.mohaberabi.kmp.foodiks.core.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.mohaberabi.kmp.foodiks.core.data.database.dao.CartDao
import com.mohaberabi.kmp.foodiks.core.data.database.dao.CategoryDao
import com.mohaberabi.kmp.foodiks.core.data.database.dao.ProductFtsDao
import com.mohaberabi.kmp.foodiks.core.data.database.dao.ProductsDao

import com.mohaberabi.kmp.foodiks.core.data.database.entity.CartEntity
import com.mohaberabi.kmp.foodiks.core.data.database.entity.CategoryEntity
import com.mohaberabi.kmp.foodiks.core.data.database.entity.ProductEntity
import com.mohaberabi.kmp.foodiks.core.data.database.entity.ProductFtsEntity


@Database(
    entities = [
        ProductEntity::class,
        ProductFtsEntity::class,
        CartEntity::class,
        CategoryEntity::class,
    ],
    version = 1,
)
@ConstructedBy(AppDatabaseCreator::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
    abstract fun categoryDao(): CategoryDao
    abstract fun productDao(): ProductsDao
    abstract fun productFtsDao(): ProductFtsDao
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object AppDatabaseCreator : RoomDatabaseConstructor<AppDatabase>