package com.mohaberabi.kmp.foodiks.platform

import androidx.room.Room
import androidx.room.RoomDatabase
import com.mohaberabi.kmp.foodiks.core.data.database.AppDatabase
import com.plusmobileapps.konnectivity.Konnectivity
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSHomeDirectory
import platform.Foundation.NSUserDomainMask


@OptIn(ExperimentalForeignApi::class)
actual val platformModule = module {


    single {
        Konnectivity()
    }
    single {

        AppConnectivityManager(get())
    }

    single<HttpClientEngine> { Darwin.create() }
    single<RoomDatabase.Builder<AppDatabase>> {
        val documentsDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = true,
            error = null,
        )?.path ?: NSHomeDirectory()
        val dbFilePath = "$documentsDirectory/foodiks.db"
        Room.databaseBuilder<AppDatabase>(
            name = dbFilePath,
        )
    }
}