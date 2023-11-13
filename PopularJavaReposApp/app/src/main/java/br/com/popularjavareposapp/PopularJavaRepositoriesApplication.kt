package br.com.popularjavareposapp

import android.app.Application
import br.com.popularjavareposapp.di.AppModule.appModule
import br.com.popularjavareposapp.di.NetworkModule.netWorkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PopularJavaRepositoriesApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PopularJavaRepositoriesApplication)
            modules(netWorkModule, appModule)
        }
    }
}