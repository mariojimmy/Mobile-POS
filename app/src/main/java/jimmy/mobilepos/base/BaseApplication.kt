package jimmy.mobilepos.base

import android.app.Application
import jimmy.mobilepos.di.prefModule
import jimmy.mobilepos.di.repositoryModule
import jimmy.mobilepos.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(prefModule, repositoryModule, viewModelModule))
        }
    }

}