package com.auttasoft.dependencyinjectionkoin

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

/**
 * Created by AuttaphonL. on 06,ธันวาคม,2566
 */
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}