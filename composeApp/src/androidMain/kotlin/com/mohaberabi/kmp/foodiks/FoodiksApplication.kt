package com.mohaberabi.kmp.foodiks

import android.app.Application
import com.mohaberabi.kmp.foodiks.platform.KoinInit
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class FoodiksApplication : Application(), KoinComponent {


    override fun onCreate() {
        super.onCreate()
        KoinInit(this@FoodiksApplication).init()
    }
}