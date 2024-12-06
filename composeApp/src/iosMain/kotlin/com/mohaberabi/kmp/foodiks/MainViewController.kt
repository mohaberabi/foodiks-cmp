package com.mohaberabi.kmp.foodiks


import androidx.compose.ui.window.ComposeUIViewController
import com.mohaberabi.kmp.foodiks.core.presentation.design_system.theme.FoodiksTheme
import com.mohaberabi.kmp.foodiks.foodiks.FoodiksComposedAppRoot
import com.mohaberabi.kmp.foodiks.foodiks.rememberFoodiksAppState
import com.mohaberabi.kmp.foodiks.platform.KoinInit


fun MainViewController(
) = ComposeUIViewController(
    configure = {
        KoinInit().init()

    }
) {
    val state = rememberFoodiksAppState()
    FoodiksTheme {
        FoodiksComposedAppRoot(
            foodiksState = state
        )

    }

}

//internal fun setupBackgroundTasks(
//) {
//    BGTaskScheduler.sharedScheduler.registerForTaskWithIdentifier(
//        SyncerConst.SYNC_UID,
//        usingQueue = dispatch_queue_main_t()
//    ) { task ->
//        CoroutineScope(Dispatchers.IO).launch {
//            IosKoinComponent.iosFoodiksSyncer.doWork()
//        }
//    }
//}
//
//internal fun logPendingTasks() {
//    BGTaskScheduler.sharedScheduler.getPendingTaskRequestsWithCompletionHandler { list ->
//        list?.forEach {
//            println("PENDING :${it.toString()}")
//        }
//    }
//}
//
