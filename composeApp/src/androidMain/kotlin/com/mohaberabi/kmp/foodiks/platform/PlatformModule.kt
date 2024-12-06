package com.mohaberabi.kmp.foodiks.platform

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import coil3.PlatformContext
import com.mohaberabi.kmp.foodiks.core.data.database.AppDatabase
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp


import org.koin.dsl.module


actual val platformModule = module {


    single<HttpClientEngine> {
        OkHttp.create()
    }

    single<RoomDatabase.Builder<AppDatabase>> {
        val dbFile = get<Context>().getDatabasePath("foodiks.db")
        Room.databaseBuilder<AppDatabase>(
            get(),
            name = dbFile.absolutePath,
        )
    }

    single<PlatformContext> { get() }
    single {
        AppConnectivityManager(get(), get())
    }
}


