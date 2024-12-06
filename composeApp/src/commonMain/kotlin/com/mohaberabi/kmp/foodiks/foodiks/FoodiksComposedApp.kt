package com.mohaberabi.kmp.foodiks.foodiks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger

import com.mohaberabi.kmp.foodiks.core.common.util.extension.dismissAndShowSnackbar
import com.mohaberabi.kmp.foodiks.core.presentation.compose.AppScaffold
import com.mohaberabi.kmp.foodiks.core.presentation.compose.EventCollector
import com.mohaberabi.kmp.foodiks.core.presentation.util.DefaultSnackBarController
import com.mohaberabi.kmp.foodiks.foodiks.navigation.FoodiksNavHost
import okio.FileSystem

val LocalSnackBarController = compositionLocalOf { DefaultSnackBarController() }

@Composable
fun FoodiksComposedAppRoot(
    foodiksState: FoodiksAppState,
) {
    FoodiksComposedApp(
        foodiksState = foodiksState,
    )
}

@Composable
fun FoodiksComposedApp(
    foodiksState: FoodiksAppState,
) {
    val rootNavController = foodiksState.foodkisNavController
    val layoutNavController = foodiksState.layoutNavController
    val hostState = foodiksState.foodiksHostState
    setSingletonImageLoaderFactory { context ->
        getAsyncImageLoader(context)
    }
    CompositionLocalProvider(
        LocalSnackBarController provides DefaultSnackBarController(),
    ) {
        val snackBarController = LocalSnackBarController.current
        EventCollector(
            flow = snackBarController.messages,
        ) { message ->
            hostState.dismissAndShowSnackbar(
                message = message,
            )
        }

        AppScaffold(
            snackBarHostState = hostState,
        ) { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .consumeWindowInsets(padding)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal,
                        ),
                    )
                    .fillMaxSize()
            ) {
                FoodiksNavHost(
                    rootNavController = rootNavController,
                    layoutNavController = layoutNavController
                )

            }
        }
    }
}

private fun getAsyncImageLoader(
    context: PlatformContext,
) =
    ImageLoader.Builder(context).memoryCachePolicy(CachePolicy.ENABLED).memoryCache {
        MemoryCache.Builder().maxSizePercent(context, 0.3).strongReferencesEnabled(true).build()
    }.diskCachePolicy(CachePolicy.ENABLED).networkCachePolicy(CachePolicy.ENABLED).diskCache {
        newDiskCache()
    }.crossfade(true).logger(DebugLogger()).build()

private fun newDiskCache(): DiskCache {
    return DiskCache.Builder().directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY / "foodiksImgCache")
        .maxSizeBytes(1024L * 1024 * 1024)
        .build()
}