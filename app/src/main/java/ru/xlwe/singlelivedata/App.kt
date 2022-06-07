package ru.xlwe.singlelivedata

import android.app.Application
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(
                appModule
            ))
        }
    }
}